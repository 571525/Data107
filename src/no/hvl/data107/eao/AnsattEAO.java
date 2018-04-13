package no.hvl.data107.eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.data107.Entity.*;

public class AnsattEAO {

	private EntityManagerFactory emf;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}

	public Ansatt finnAnsattMedId(int id) {

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt = null;
		try {
			ansatt = em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
		return ansatt;
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();
		Ansatt a = null;
		String queryString = "SELECT a FROM oblig3.Ansatt a" + "WHERE a.brukernavn = :brukernavn";

		try {
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			a = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public void skrivUtAlleAnsatte() {

		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatte;

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM oblig3.Ansatt a", Ansatt.class);
			ansatte = query.getResultList();
			for (Ansatt a : ansatte) {
				a.skrivUt("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// Gjøre a og p managed
			a = em.merge(a);
			p = em.merge(p);

			// Opprette og lagre en ny prosjektdeltagelse
			Prosjektdeltagelse prosjektdeltagelse = new Prosjektdeltagelse(a, p, 0, "");
			em.persist(prosjektdeltagelse);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}

	}

	public void slettProsjektdeltagelse(Ansatt a, Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// Finne aktuell prosjektdeltagelse
			Prosjektdeltagelse prosjektdeltagelse = finnProsjektdeltagelse(a.getId(), p.getId());
			// NB! Er ikke mangaged siden vi bruker en hjelpemetode som closer em. Må
			// derfor:
			prosjektdeltagelse = em.merge(prosjektdeltagelse);

			// Gjøre a og p managed
			a = em.merge(a);
			p = em.merge(p);

			// Oppdatere koblinger
			a.fjernProsjektdeltagelse(prosjektdeltagelse);
			p.fjernProsjektdeltagelse(prosjektdeltagelse);

			// Slette prosjektdeltagelse
			em.remove(prosjektdeltagelse);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	private Prosjektdeltagelse finnProsjektdeltagelse(int ansattId, int prosjektId) {

		String queryString = "SELECT pd FROM Prosjektdeltagelse pd "
				+ "WHERE pd.ansatt.ansattId = :ansattId AND pd.prosjekt.prosjektId = :prosjektId";

		EntityManager em = emf.createEntityManager();

		Prosjektdeltagelse pd = null;
		try {
			TypedQuery<Prosjektdeltagelse> query = em.createQuery(queryString, Prosjektdeltagelse.class);
			query.setParameter("ansattId", ansattId);
			query.setParameter("prosjektId", prosjektId);
			pd = query.getSingleResult();

		} catch (NoResultException e) {
			// e.printStackTrace();
		} finally {
			em.close();
		}
		return pd;
	}

}

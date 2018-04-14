package no.hvl.data107.eao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.Entity.Avdeling;

public class AvdelingEAO {

	private EntityManagerFactory emf;

	public AvdelingEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}

	public void OprettNyAvdeling() {
		EntityManager em = emf.createEntityManager();
		Scanner in = new Scanner(System.in);

		try {
			em.getTransaction().begin();
			System.out.println("Angi navn på ny avdeling: ");
			String navn = in.nextLine();
			System.out.println("Angi ID på ny sjef: ");
			int id = Integer.parseInt(in.next());

			Ansatt sjef = em.find(Ansatt.class, id);
			AnsattEAO sjek = new AnsattEAO();

			if (!sjek.erSjefIAvdeling(id)) {
				Avdeling ny = new Avdeling(sjef, navn);
				em.persist(ny);
			}
			else {
				System.out.println("FEIL: Ansatt er allerede sjef i en avdeling");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avd = null;
		try {
			avd = em.find(Avdeling.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return avd;
	}

	public void skrivUtAvdelingInfo(int avdId) {
		EntityManager em = emf.createEntityManager();

		List<Ansatt> ansatte;

		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"SELECT a FROM Ansatt a " + "WHERE a.avdeling.avdelingId = :avdelingId ", Ansatt.class);
			query.setParameter("avdelingId", avdId);
			ansatte = query.getResultList();
			Avdeling avd = em.find(Avdeling.class, avdId);
			avd.skrivUt();
			for (Ansatt a : ansatte) {
				a.skrivUt("");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
}

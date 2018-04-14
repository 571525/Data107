package no.hvl.data107.eao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.Entity.Prosjekt;
import no.hvl.data107.Entity.Prosjektdeltagelse;

public class ProsjektdeltagelseEAO {

	private EntityManagerFactory emf;

	public ProsjektdeltagelseEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}

	public Prosjekt finnProsjektMedId(int id) {

		EntityManager em = emf.createEntityManager();

		Prosjekt prosjekt = null;
		try {
			prosjekt = em.find(Prosjekt.class, id);
		} finally {
			em.close();
		}
		return prosjekt;
	}

	public void nyProsjektdeltagelse() {

		EntityManager em = emf.createEntityManager();
		Scanner in = new Scanner(System.in);
		AnsattEAO ansEAO = new AnsattEAO();
		ProsjektEAO proEAO = new ProsjektEAO();
		
		try {
			System.out.println("Angi ansatt ID: ");
			int ansId = Integer.parseInt(in.next());
			Ansatt a = ansEAO.finnAnsattMedId(ansId);
		
			System.out.println("Angi prosjekt ID: ");
			int proId = Integer.parseInt(in.next());
			Prosjekt p = proEAO.finnProsjektMedId(proId);
			
			System.out.println("Angi rolle i prosjektet: ");
			String rolle = in.nextLine();
			
			Prosjektdeltagelse prodel = new Prosjektdeltagelse(a, p, 0, rolle);
			
			em.getTransaction().begin();
			em.persist(prodel);
			em.getTransaction().commit();
			System.out.println("Ansatt er tilføjet prosjektet");

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

}

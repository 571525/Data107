package no.hvl.data107.eao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.*;

public class ProsjektEAO {

    private EntityManagerFactory emf;

    public ProsjektEAO() {
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
    
    public void leggInnNyttProsjekt() {
    	EntityManager em = emf.createEntityManager();
    	Scanner in = new Scanner(System.in);
    	
    	try {
    		System.out.println("Angi navn på prosjekt: ");
    		String navn = in.nextLine();
    		System.out.println("Giv beskrivelse av prosjektet: ");
    		String beskrivelse = in.nextLine();
    		Prosjekt ny = new Prosjekt(navn, beskrivelse);
    		em.getTransaction().begin();
    		em.persist(ny);
    		em.getTransaction().commit();
    		System.out.println("Prosjektet er oprettet");
    	}catch(Exception e) {
    		em.getTransaction().rollback();
    	}finally {
    		em.close();
    	}
    }
    
}

package no.hvl.data107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Ansatt;

public class Main {

    public static void main(String[] args) {
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
       EntityManager em = emf.createEntityManager();
       
       Ansatt a = em.find(Ansatt.class, 1);
       a.skrivUt("");
    }

}

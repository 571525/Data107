package no.hvl.data107.eao;

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
}

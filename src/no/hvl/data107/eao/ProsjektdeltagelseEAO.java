package no.hvl.data107.eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.Entity.Prosjekt;

public class ProsjektdeltagelseEAO {
	
	private EntityManagerFactory emf;
	
public ProsjektdeltagelseEAO () {
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

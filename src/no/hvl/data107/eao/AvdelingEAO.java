package no.hvl.data107.eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Avdeling;

public class AvdelingEAO {
	
	private EntityManagerFactory emf;
	
	public AvdelingEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3PersistenceUnit");
	}
	
	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avd = null;
		try {
		avd = em.find(Avdeling.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	return avd;
	}
}

package no.hvl.data107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.eao.AnsattEAO;
import no.hvl.data107.eao.AvdelingEAO;

public class Main {

    public static void main(String[] args) {
        
    	Meny meny = new Meny();
    	meny.start();
    }

}

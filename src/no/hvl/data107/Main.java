package no.hvl.data107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.eao.AnsattEAO;

public class Main {

    public static void main(String[] args) {
        
       AnsattEAO aEAO = new AnsattEAO();
       
       aEAO.leggTilNyAnsatt();
    }

}

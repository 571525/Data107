package no.hvl.data107;

import java.util.Scanner;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.eao.AnsattEAO;
import no.hvl.data107.eao.AvdelingEAO;
import no.hvl.data107.eao.ProsjektEAO;
import no.hvl.data107.eao.ProsjektdeltagelseEAO;

public class Meny {

private Scanner in;	
	

public Meny() {
	in = new Scanner(System.in);
	
};
	
public void start() {
	
	AnsattEAO ansEAO = new AnsattEAO();
	AvdelingEAO avdEAO = new AvdelingEAO();
	ProsjektEAO proEAO = new ProsjektEAO();
	ProsjektdeltagelseEAO prodelEAO = new ProsjektdeltagelseEAO();
	
	int i = -1;
	do {
	
		System.out.println(" \n Valgmuligheter: \n 0: Avslutt programm \n 1: Legg inn ny ansatt \n 2: Søk ansatt vha ansatt ID \n 3: Søk ansatt vha brukernavn \n 4: Utlist alle ansate \n 5: Opdater en ansatt's lønn eller stilling \n 6: Søk avdeling vha avdeling ID \n 7: Utlist ansatte og sjef i avdeling \n 8: Byt avdeling for en ansatt \n 9: Oprett ny avdeling");
		i = in.nextInt();
		switch(i) {
		case 1: {
			ansEAO.leggTilNyAnsatt();
		}
		case 2: {
			System.out.println("Angi ID: ");
			int id = in.nextInt();
			Ansatt a = ansEAO.finnAnsattMedId(id);
			a.skrivUt("\t");
		}
		case 3:{
			System.out.println("Angi brukernavn: ");
			String brukernavn = in.next();
			Ansatt a = ansEAO.finnAnsattMedBrukernavn(brukernavn);
			a.skrivUt("\t");
		}
		case 4: {
			ansEAO.skrivUtAlleAnsatte();
		}
		case 5: {
			System.out.println("Angi ansatt ID: ");
			int id = in.nextInt();
			Ansatt a = ansEAO.finnAnsattMedId(id);
			
			System.out.println("Velg: \n 1: Opdater lønn \n 2: Opdater stilling");
			int valg = in.nextInt();
			if(valg == 1) {
				System.out.println("Angi ny lønn: ");
				float nyLønn = Float.parseFloat(in.next());
				ansEAO.opdaterLønn(a, nyLønn);
			}
			else if (valg == 2) {
				System.out.println("Angi ny stilling: ");
				String nyStilling = in.next();
				ansEAO.opdaterStilling(a, nyStilling);
			}
		}
		}
		
	}while (i != 0);
	
}

}

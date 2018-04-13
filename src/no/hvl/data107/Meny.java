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
		i = Integer.parseInt(in.next());
		switch(i) {
		case 1: {
			ansEAO.leggTilNyAnsatt();
			i=-1;
			break;
		}
		case 2: {
			System.out.println("Angi ID: ");
			int id = Integer.parseInt(in.next());
			Ansatt a = ansEAO.finnAnsattMedId(id);
			a.skrivUt("\t");
			i=-1;
			break;
		}
		case 3:{
			System.out.println("Angi brukernavn: ");
			String brukernavn = in.next();
			Ansatt a = ansEAO.finnAnsattMedBrukernavn(brukernavn);
			a.skrivUt("\t");
			i=-1;
			break;
		}
		case 4: {
			ansEAO.skrivUtAlleAnsatte();
			i=-1;
			break;
		}
		case 5: {
			System.out.println("Angi ansatt ID: ");
			int id = Integer.parseInt(in.next());
			Ansatt a = ansEAO.finnAnsattMedId(id);
			
			System.out.println("Velg: \n 1: Opdater lønn \n 2: Opdater stilling");
			int valg = Integer.parseInt(in.nextLine());
			if(valg == 1) {
				System.out.println("Angi ny lønn: ");
				float nyLønn = Float.parseFloat(in.next());
				ansEAO.opdaterLønn(a, nyLønn);
			}
			else if (valg == 2) {
				System.out.println("Angi ny stilling: ");
				String nyStilling = in.nextLine();
				ansEAO.opdaterStilling(a, nyStilling);
			}
			else {
				System.out.println("Ikkee gyldigt valg.");
			}
			i=-1;
			break;
		}
		}
		
	}while (i != 0);
	
}

}

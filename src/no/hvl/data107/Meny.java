package no.hvl.data107;

import java.util.Scanner;

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
			
		}
		}
		
	}while (i != 0);
	
}

}

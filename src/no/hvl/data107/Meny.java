package no.hvl.data107;

import java.util.Scanner;

import no.hvl.data107.Entity.Ansatt;
import no.hvl.data107.Entity.Avdeling;
import no.hvl.data107.Entity.Prosjekt;
import no.hvl.data107.Entity.Prosjektdeltagelse;
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
			try {
				System.out.println(" \n Valgmuligheter: " + "\n   0: Avslutt programm " + "\n   1: Legg inn ny ansatt "
						+ "\n   2: Søk ansatt vha ansatt ID " + "\n   3: Søk ansatt vha brukernavn "
						+ "\n   4: Utlist alle ansate " + "\n   5: Opdater en ansatt's lønn eller stilling "
						+ "\n   6: Søk avdeling vha avdeling ID " + "\n   7: Utlist ansatte og sjef i avdeling "
						+ "\n   8: Byt avdeling for en ansatt " + "\n   9: Oprett ny avdeling "
						+ "\n  10: Legg inn nyt prosjekt" + "\n  11: Registrer prosjektdeltagelse"
						+ "\n  12: Føre timer for en ansatt på et prosjekt"
						+ "\n  13: Skriv ut alle info om et prosjekt" + "\nValg=  ");
				i = Integer.parseInt(in.next());
				switch (i) {
				case 1: {
					ansEAO.leggTilNyAnsatt();
					break;
				}
				case 2: {
					System.out.println("Angi ID: ");
					int id = Integer.parseInt(in.next());
					Ansatt a = ansEAO.finnAnsattMedId(id);
					a.skrivUt("\t");
					break;
				}
				case 3: {
					System.out.println("Angi brukernavn: ");
					String brukernavn = in.next();
					Ansatt a = ansEAO.finnAnsattMedBrukernavn(brukernavn);
					a.skrivUt("\t");
					break;
				}
				case 4: {
					ansEAO.skrivUtAlleAnsatte();
					break;
				}
				case 5: {
					System.out.println("Angi ansatt ID: ");
					int id = Integer.parseInt(in.next());
					Ansatt a = ansEAO.finnAnsattMedId(id);

					System.out.println("Velg: \n 1: Opdater lønn \n 2: Opdater stilling");
					int valg = Integer.parseInt(in.next());
					if (valg == 1) {
						System.out.println("Angi ny lønn: ");
						float nyLønn = Float.parseFloat(in.next());
						ansEAO.opdaterLønn(a, nyLønn);
					} else if (valg == 2) {
						System.out.println("Angi ny stilling: ");
						String nyStilling = in.next();
						ansEAO.opdaterStilling(a, nyStilling);
					} else {
						System.out.println("Ikke et gyldigt valg.");
					}
					break;
				}
				case 6: {
					System.out.println("Angi avdeling ID: ");
					int id = Integer.parseInt(in.next());
					Avdeling avd = avdEAO.finnAvdelingMedId(id);
					avd.skrivUt();
					i=-1;
					break;
				}
				case 7: {
					System.out.println("Angi avdling ID: ");
					int id = Integer.parseInt(in.next());
					avdEAO.skrivUtAvdelingInfo(id);
					break;
				}
				case 8: {
					System.out.println("Angi ansatt ID: ");
					int ansattId = Integer.parseInt(in.next());
					System.out.println("Angi ny avdeling's ID: ");
					int nyAvdId = Integer.parseInt(in.next());
					ansEAO.bytAvdeling(ansattId, nyAvdId);
					break;
				}
				case 9: {
					avdEAO.OprettNyAvdeling();
					break;
				}
				case 10: {
					proEAO.leggInnNyttProsjekt();
					break;
				}
				case 11: {
					prodelEAO.nyProsjektdeltagelse();
					break;
				}
				case 12: {
					System.out.println("Angi ansatt ID: ");
					int ansId = Integer.parseInt(in.next());
					System.out.println("Angi projsekt ID: ");
					int proId = Integer.parseInt(in.next());
					System.out.println("Angi antall timer du vil tilføje: ");
					int timer = Integer.parseInt(in.next());
					ansEAO.førTimerForEtProsjekt(ansId, proId, timer);
					break;
				}
				case 13: {
					System.out.println("Angi prosjekt ID: ");
					int id = Integer.parseInt(in.next());
					Prosjekt p = proEAO.finnProsjektMedId(id);
					p.skrivUtMedAnsatte();
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Noe gikk galt, prøv igjen...");
			}

		} while (i != 0);

	}

}

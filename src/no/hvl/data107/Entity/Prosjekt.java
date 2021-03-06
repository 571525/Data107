package no.hvl.data107.Entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//JPA-annotations
@Entity 
@Table(schema = "oblig3")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektId;
    
    private String navn;
    private String beskrivelse;
    
    @OneToMany(mappedBy="prosjekt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public Prosjekt() {}
    
    public Prosjekt(String navn, String beskrivelse) {
    	this.navn = navn;
    	this.beskrivelse = beskrivelse;
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s: %s", innrykk, prosjektId, navn, beskrivelse);
    }
    
    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(a -> a.skrivUt("\n   "));
        int totalTimer = 0;
        for(int i = 0; i < deltagelser.size(); i++) {
        	totalTimer += deltagelser.get(i).getTimer();
        }
        System.out.println();
        System.out.println("Total antall timer: " + totalTimer);
    }
 

    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.add(prosjektdeltagelse);
    }

    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.remove(prosjektdeltagelse);
    }

	public int getId() {
		return prosjektId;
	}

	public void setId(int id) {
		this.prosjektId = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}
}
    
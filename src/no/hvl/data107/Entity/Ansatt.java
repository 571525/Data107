package no.hvl.data107.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// JPA-annotations
@Entity
@Table(schema = "oblig3")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;
    
    private String fornavn;
    private String etternavn;
    private String brukernavn;
    private String stilling;
    private int avdelingId;
    private float maanedsloenn;
    private String datoAnsatt;
    
    @OneToMany(mappedBy="ansatt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public Ansatt(String fornavn, String etternavn, String brukernavn, String stilling, int avdelingId, float maanedsloenn, String datoAnsatt) {
    	this.fornavn = fornavn;
        this.etternavn = etternavn;
	    this.brukernavn = brukernavn;
	    this.stilling = stilling;
        this.avdelingId = avdelingId;
        this.maanedsloenn = maanedsloenn;
        this.datoAnsatt = datoAnsatt;  	
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %d: %s %s,brukernavn: %s, Stilling: %s, Lønn; %f Avd: %d Ansatt: %s", innrykk, ansattId, fornavn, etternavn, brukernavn, stilling, maanedsloenn, avdelingId, datoAnsatt);
    }
    
    public void skrivUtMedProsjekter() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(p -> p.skrivUt("\n   "));
    }

    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.add(prosjektdeltagelse);
    }

    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
        deltagelser.remove(prosjektdeltagelse);
    }

	public int getId() {
		return ansattId;
	}

	public void setId(int id) {
		this.ansattId = id;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}

	public float getMaanedsloenn() {
		return maanedsloenn;
	}

	public void setMaanedsloenn(float maanedsloenn) {
		this.maanedsloenn = maanedsloenn;
	}

	public String getDatoAnsatt() {
		return datoAnsatt;
	}

	public void setDatoAnsatt(String datoAnsatt) {
		this.datoAnsatt = datoAnsatt;
	}
	
    
}
    
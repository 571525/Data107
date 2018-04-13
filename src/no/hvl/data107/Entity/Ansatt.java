package no.hvl.data107.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.data107.eao.AvdelingEAO;


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
    
    @ManyToOne
    @JoinColumn (name = "avdelingId")
    private Avdeling avdeling;
    
    private float maanedsloenn;
    private java.time.LocalDate datoAnsatt;
    
    @OneToMany(mappedBy="ansatt")
    private List<Prosjektdeltagelse> deltagelser;
    
    public Ansatt() {}
    
    public Ansatt(String fornavn, String etternavn, String brukernavn, String stilling, int avdelingId, float maanedsloenn, java.time.LocalDate datoAnsatt) {
    	this.fornavn = fornavn;
        this.etternavn = etternavn;
	    this.brukernavn = brukernavn;
	    this.stilling = stilling;
	    try {
	    AvdelingEAO avd = new AvdelingEAO();
	    this.avdeling = avd.finnAvdelingMedId(avdelingId);
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
        this.maanedsloenn = maanedsloenn;
        this.datoAnsatt = datoAnsatt;  	
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sAnsatt nr %d: %s %s,brukernavn: %s, Stilling: %s, Lønn; %f Avd: %s Ansatt: %s", innrykk, ansattId, fornavn, etternavn, brukernavn, stilling, maanedsloenn, avdeling.getNavn(), datoAnsatt);
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

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdelingId) {
		this.avdeling = avdelingId;
	}

	public float getMaanedsloenn() {
		return maanedsloenn;
	}

	public void setMaanedsloenn(float maanedsloenn) {
		this.maanedsloenn = maanedsloenn;
	}

	public java.time.LocalDate getDatoAnsatt() {
		return datoAnsatt;
	}

	public void setDatoAnsatt(java.time.LocalDate datoAnsatt) {
		this.datoAnsatt = datoAnsatt;
	}
	
    
}
    
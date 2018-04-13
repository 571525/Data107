package no.hvl.data107.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int avdelingId;

@OneToOne
@JoinColumn
Ansatt sjef;

private String navn;

//@OneToMany (mappedBy = "avdeling")
//List<Ansatt> ansatte;

public Avdeling () {}

public Avdeling (Ansatt sjef, String navn) {
	this.sjef = sjef;
	this.navn = navn;
}

public int getAvdelingId() {
	return avdelingId;
}

public void setAvdelingId(int avdelingId) {
	this.avdelingId = avdelingId;
}

public Ansatt getSjef() {
	return sjef;
}

public void setSjef(Ansatt sjef) {
	this.sjef = sjef;
}

public String getNavn() {
	return navn;
}

public void setNavn(String navn) {
	this.navn = navn;
}

}

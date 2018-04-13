package no.hvl.data107.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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



//@OneToMany (mappedBy = avdeling)
//List<Ansatt> ansatte;

}

package no.hvl.data107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Ansatt {
	@Id
	@GeneratedValue
	int ansattID;
	@ManyToOne
	@JoinColumn
	Avdeling avdeling;
	
	//@OneToOne (mappedBy = sjef)
	// Avdeling sjefAvdeling;
}

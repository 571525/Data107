package no.hvl.data107;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Prosjektdeltagelse {

	//Må lage en såkalt ID klasse
	
	@Id
	@ManyToOne
	@JoinColumn
	Prosjekt prosjekt;
	
	@Id
	@ManyToOne
	@JoinColumn
	Ansatt ansatt;
}

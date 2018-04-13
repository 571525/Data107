package no.hvl.data107.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//JPA-annotations
@Entity 
@Table(schema = "oblig3")
public class Prosjektdeltagelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektdeltagelseId;
    
    private int timer;
    private String rolle;
    
    @ManyToOne
    @JoinColumn(name="ansattId")
    private Ansatt ansatt;
    
    @ManyToOne
    @JoinColumn(name="prosjektId")
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int timer, String rolle) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.timer = timer;
        this.rolle = rolle;
        
        //Hvis vi gjør dette her slipper vi å gjøre det i EAO
        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer, Rolle: %s", innrykk, 
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer, rolle);
    }
    
}








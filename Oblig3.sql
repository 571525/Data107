-- SQL for en-til-mange-eksemplet gjennomgått i timen tirsdag 3. april 

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
ID SERIAL UNIQUE PRIMARY KEY,
brukernavn VARCHAR(4) UNIQUE,
fornavn VARCHAR,
etternavn VARCHAR,
dato_ansatt DATE,
stilling VARCHAR,
månedslønn INTEGER,
avdelingsNr INTEGER FOREIGN KEY REFERENCES Avdeling (avdelingsNr), 
CONSTRAINT rolle VARCHAR FOREIGN KEY REFERENCES Prosjekt(prosjektID) 
);

CREATE TABLE Avdeling
(
	avdelingsNr SERIAL UNIQUE PRIMARY KEY,
  	navn VARCHAR,
  	CONSTRAINT chef INTEGER FOREIGN KEY (ID) REFERENCES Ansatt(ID), 
);

CREATE TABLE Prosjekt (
	prosjektID SERIAL UNIQUE PRIMARY KEY,
	navn VARCHAR,
	beskrivelse TEXT,
	

);
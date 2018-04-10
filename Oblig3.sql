-- SQL for en-til-mange-eksemplet gjennomgått i timen tirsdag 3. april 

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    

CREATE TABLE Ansatt
(
ansattID SERIAL,
brukernavn VARCHAR(4) UNIQUE NOT NULL,
fornavn VARCHAR(255) NOT NULL,
etternavn VARCHAR(255) NOT NULL,
dato_ansatt DATE NOT NULL,
stilling VARCHAR(255)NOT NULL,
månedslønn FLOAT NOT NULL,
avdID INTEGER NOT NULL,
--FOREIGN KEY (avdelingsNr) REFERENCES Avdeling (avdelingsNr),
CONSTRAINT ansattID PRIMARY KEY (ansattID)
);

CREATE TABLE Avdeling
(
	avdID SERIAL,
  	navn VARCHAR(255),
	chef INTEGER NOT NULL,
  	CONSTRAINT chef FOREIGN KEY (chef) REFERENCES Ansatt(ansattID),
  	CONSTRAINT avdID PRIMARY KEY (acdID)
);

CREATE TABLE Prosjekt (
	prosjektID SERIAL,
	navn VARCHAR(255),
	beskrivelse TEXT,
	CONSTRAINT prosjektID PRIMARY KEY (prosjektID)
);

ALTER TABLE Ansatt ADD CONSTRAINT AvdelingFK FOREIGN KEY (avdID) REFERENCES Avdeling (avdID);
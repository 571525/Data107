-- SQL for en-til-mange-eksemplet gjennomgått i timen tirsdag 3. april 

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    

CREATE TABLE Ansatt
(
ansattId SERIAL,
brukernavn VARCHAR(4) UNIQUE NOT NULL,
fornavn VARCHAR(50),
etternavn VARCHAR(50),
datoAnsatt DATE,
stilling VARCHAR(255),
månedslønn FLOAT,
avdelingId INTEGER,
--CONSTRAINT avdelingID FOREIGN KEY (avdelingId) REFERENCES Avdeling (avdelingId),
CONSTRAINT ansattId PRIMARY KEY (ansattId)
);

CREATE TABLE Avdeling
(
	avdelingId SERIAL,
  	navn VARCHAR(50),
	chef INTEGER NOT NULL,
  	CONSTRAINT chef FOREIGN KEY (chef) REFERENCES Ansatt(ansattId),
  	CONSTRAINT avdelingId PRIMARY KEY (avdelingId)
);

CREATE TABLE Prosjekt (
	prosjektId SERIAL,
	navn VARCHAR(50),
	beskrivelse TEXT,
	CONSTRAINT prosjektId PRIMARY KEY (prosjektId)
);

CREATE TABLE Prosjektdeltagelse
(
  prosjektdeltagelseId SERIAL,
  ansattId INTEGER,
  prosjektId INTEGER,
  timer     INTEGER,
  rolle VARCHAR(100),
  CONSTRAINT ProsjektdeltagelsePK PRIMARY KEY (prosjektdeltagelseId),
  CONSTRAINT ansattProsjektUnik UNIQUE (ansattId, prosjektId),
  CONSTRAINT ansattFK FOREIGN KEY (ansattId) REFERENCES Ansatt(ansattId),
  CONSTRAINT prosjektFK FOREIGN KEY (prosjektId) REFERENCES Prosjekt(prosjektId)  
);

ALTER TABLE Ansatt ADD CONSTRAINT avdelingFK FOREIGN KEY (avdelingId) REFERENCES Avdeling (avdelingId);
  
INSERT INTO
  Ansatt(fornavn, etternavn, brukernavn, datoAnsatt, månedslønn, stilling)
VALUES
  ('Arne', 'Arnesen', 'arar', '12-12-2012', 1111.11, 'chef'),
  ('Brit', 'Britsen', 'brbr', '11-11-2011', 2222.22, 'chef'),
  ('Carl', 'Carlsen', 'caca', '10-10-2010', 3333.33, 'kaffe henter'),
  ('Donald', 'Duck', 'dodu', '09-09-2009', 4444.44, 'programmør');

INSERT INTO
  Prosjekt(navn, beskrivelse)
VALUES
  ('Trivselsprosjektet', 'For å få bedre trivsel'),
  ('Synergiprosjektet', 'For å gi synergi'),
  ('Utviklingsprosjektet', 'For å utvikle');

INSERT INTO
  Prosjektdeltagelse(ansattId, prosjektId, timer, rolle)
VALUES
  (1, 1, 50, 'ideskaper'),
  (2, 1, 100, 'programmør'),
  (2, 2, 150, 'klovn'),
  (3, 1, 200, 'kaffe henter'),
  (3, 2, 250, 'stativ'),
  (4, 1, 300, 'kok');
  
 INSERT INTO 
 Avdeling (navn, chef)  
 VALUES
  ('Innkjøp', 1),
  ('Utvikling', 2);
  
  
 UPDATE Ansatt
 SET avdelingId = 1
 WHERE ansattId = 1 OR ansattID = 2;
 
 UPDATE Ansatt
 SET avdelingId = 2
 WHERE ansattId = 3 OR ansattID = 4;
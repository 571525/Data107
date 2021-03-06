DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    

CREATE TABLE Ansatt
(
ansattId SERIAL,
brukernavn VARCHAR(4) UNIQUE NOT NULL,
fornavn VARCHAR(50) NOT NULL,
etternavn VARCHAR(50) NOT NULL,
datoAnsatt DATE NOT NULL,
stilling VARCHAR(255) NOT NULL,
maanedsloenn NUMERIC(10,2) NOT NULL,
avdelingId INTEGER,
--CONSTRAINT avdelingID FOREIGN KEY (avdelingId) REFERENCES Avdeling (avdelingId),
CONSTRAINT ansattId PRIMARY KEY (ansattId)
);

CREATE TABLE Avdeling
(
	avdelingId SERIAL,
  	navn VARCHAR(50) NOT NULL,
    sjef INTEGER UNIQUE,
    CONSTRAINT sjef FOREIGN KEY (sjef) REFERENCES Ansatt(ansattId),
  	CONSTRAINT avdelingId PRIMARY KEY (avdelingId)
);

CREATE TABLE Prosjekt (
	prosjektId SERIAL,
	navn VARCHAR(50) NOT NULL,
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
  
INSERT INTO Avdeling (navn) VALUES ('Innkj�p'), ('Utvikling');

INSERT INTO
  Ansatt(fornavn, etternavn, brukernavn, datoAnsatt, maanedsloenn, stilling, avdelingId)
VALUES
  ('Arne', 'Arnesen', 'arar', '12-12-2012', 1111.11, 'chef', 1),
  ('Brit', 'Britsen', 'brbr', '11-11-2011', 2222.22, 'chef', 2),
  ('Carl', 'Carlsen', 'caca', '10-10-2010', 3333.33, 'kaffe henter', 1),
  ('Donald', 'Duck', 'dodu', '09-09-2009', 4444.44, 'programm�r', 2);

UPDATE Avdeling SET sjef = 1 WHERE avdelingId = 1;
UPDATE Avdeling SET sjef = 2 WHERE avdelingId = 2;
ALTER TABLE Avdeling ALTER COLUMN sjef SET NOT NULL; 

INSERT INTO
  Prosjekt(navn, beskrivelse)
VALUES
  ('Trivselsprosjektet', 'For � f� bedre trivsel'),
  ('Synergiprosjektet', 'For � gi synergi'),
  ('Utviklingsprosjektet', 'For � utvikle');

INSERT INTO
  Prosjektdeltagelse(ansattId, prosjektId, timer, rolle)
VALUES
  (1, 1, 50, 'ideskaper'),
  (2, 1, 100, 'programm�r'),
  (2, 2, 150, 'klovn'),
  (3, 1, 200, 'kaffe henter'),
  (3, 2, 250, 'stativ'),
  (4, 1, 300, 'kok');
 
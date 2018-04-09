-- SQL for en-til-mange-eksemplet gjennomgått i timen tirsdag 3. april 

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
ID INTEGER IDENTITY(1,1) PRIMARY KEY,
brukernavn VARCHAR(4) UNIQUE NOT NULL,
fornavn VARCHAR,
etternavn VARCHAR,
dato_ansatt DATE,
stilling VARCHAR,
månedslønn INTEGER,
avdelingsNr INTEGER FOREIGN KEY REFERENCES Avdeling (avdelingsNr), 
prosjekt VARCHAR FOREIGN KEY REFERENCES Prosjekt(prosjektID) 
);

CREATE TABLE Karakter
(
    KarNr       SERIAL,
    Kurskode    CHAR(6) NOT NULL,
    EksDato     DATE NOT NULL,
    Karakter    CHAR(1) NOT NULL, -- NB! Bør kanskje hete noe annet enn Karakter
    StudNr      INTEGER NOT NULL,
    CONSTRAINT KarakterPN PRIMARY KEY (KarNr),
    CONSTRAINT KarUnique UNIQUE (Kurskode, StudNr),
    CONSTRAINT VitnemalFK FOREIGN KEY (StudNr) REFERENCES Vitnemal(StudNr)
);

INSERT INTO
  Vitnemal(StudNr, Studiestart, Studieslutt)
VALUES
    (123456, '2017-08-14', '2020-08-14'),
    (234567, '2017-08-14', '2020-08-14'),
    (345678, '2017-08-14', '2020-08-14');

-- NB! Databasen genererer selv primærnøkler. Den skal ikke oppgis ved INSERT.    
INSERT INTO
  Karakter(Kurskode, EksDato, Karakter, StudNr)
VALUES
    ('DAT107', '2018-05-30', 'A', 123456),
    ('DAT102', '2018-05-31', 'A', 123456),
    ('DAT107', '2018-05-30', 'B', 234567);
    


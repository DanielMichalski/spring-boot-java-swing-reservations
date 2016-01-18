/*==============================================================*/

DROP TABLE IF EXISTS Adres CASCADE;

DROP TABLE IF EXISTS Klient CASCADE;

DROP TABLE IF EXISTS Platnosc CASCADE;

DROP TABLE IF EXISTS PlatnoscMetoda CASCADE;

DROP TABLE IF EXISTS Pokoj CASCADE;

DROP TABLE IF EXISTS Pokoj_x_Rezerwacja CASCADE;

DROP TABLE IF EXISTS PokojStatus CASCADE;

DROP TABLE IF EXISTS PokojTyp CASCADE;

DROP TABLE IF EXISTS Rezerwacja CASCADE;

DROP TABLE IF EXISTS Status_Rezerwacji CASCADE;

DROP TABLE IF EXISTS Stawka CASCADE;

DROP TABLE IF EXISTS klientHistoria CASCADE;

DROP TABLE IF EXISTS adresHistoria CASCADE;

/*==============================================================*/
/* Table: Adres                                                 */
/*==============================================================*/

CREATE TABLE Adres
(
  IDAdres       SERIAL NOT NULL PRIMARY KEY,
  Ulica         TEXT   NOT NULL,
  Nr_domu       TEXT   NOT NULL,
  Nr_Mieszkania TEXT   NOT NULL,
  Miasto        TEXT   NOT NULL,
  Kod_pocztowy  TEXT   NOT NULL CHECK (length(Kod_pocztowy) IN (5, 6))
);

/*==============================================================*/
/* Table: Klient                                                */
/*==============================================================*/

CREATE TABLE Klient
(
  IDKlient SERIAL NOT NULL PRIMARY KEY,
  IDAdres  INT    NOT NULL REFERENCES Adres (IDAdres),
  Imie     TEXT   NOT NULL,
  Nazwisko TEXT   NOT NULL,
  PESEL    TEXT   NOT NULL,
  Telefon  TEXT   NOT NULL,
  Email    TEXT   NOT NULL
);

/*==============================================================*/
/* Table: PlatnoscMetoda                                        */
/*==============================================================*/

CREATE TABLE PlatnoscMetoda
(
  IDPlatnoscMetoda SERIAL NOT NULL PRIMARY KEY,
  Nazwa            TEXT   NOT NULL
);

/*==============================================================*/
/* Table: Platnosc                                              */
/*==============================================================*/

CREATE TABLE Platnosc
(
  IDPlatnosc       SERIAL NOT NULL PRIMARY KEY,
  IDPlatnoscMetoda INT    NOT NULL REFERENCES PlatnoscMetoda (IDPlatnoscMetoda),
  Wartosc          INT    NOT NULL,
  DataPlatnosci    DATE   NOT NULL
);

/*==============================================================*/
/* Table: PokojStatus                                           */
/*==============================================================*/

CREATE TABLE PokojStatus
(
  IDPokojStatus SERIAL NOT NULL PRIMARY KEY,
  StatusPokoju  TEXT   NOT NULL,
  OpisStatusu   TEXT   NOT NULL
);

/*==============================================================*/
/* Table: Pokoj                                                 */
/*==============================================================*/

CREATE TABLE Pokoj
(
  IDPokoj       SERIAL NOT NULL PRIMARY KEY,
  IDPokojStatus INT    NOT NULL REFERENCES PokojStatus (IDPokojStatus),
  LiczbaOsob    INT    NOT NULL,
  Opis          TEXT   NOT NULL
);

/*==============================================================*/
/* Table: PokojTyp                                              */
/*==============================================================*/

CREATE TABLE PokojTyp
(
  IDPokojTyp SERIAL NOT NULL PRIMARY KEY,
  Opis       TEXT   NOT NULL,
  Mnoznik    INT    NOT NULL
);

/*==============================================================*/
/* Table: Status_Rezerwacji                                     */
/*==============================================================*/

CREATE TABLE Status_Rezerwacji
(
  IDStatusRezerwacja SERIAL NOT NULL PRIMARY KEY,
  Status_Rezerwacji  TEXT   NOT NULL
);

/*==============================================================*/
/* Table: Stawka                                                */
/*==============================================================*/

CREATE TABLE Stawka
(
  IDStawka         SERIAL NOT NULL PRIMARY KEY,
  IDPokoj          INT    NOT NULL REFERENCES Pokoj (IDPokoj),
  IDPokojTyp       INT    NOT NULL REFERENCES PokojTyp (IDPokojTyp),
  StawkaPodstawowa INT    NOT NULL
);

/*==============================================================*/
/* Table: Rezerwacja                                            */
/*==============================================================*/

CREATE TABLE Rezerwacja
(
  IDRezerwacja       SERIAL NOT NULL PRIMARY KEY,
  IDStatusRezerwacja INT    NOT NULL REFERENCES Status_Rezerwacji (IDStatusRezerwacja),
  IDPlatnosc         INT    NOT NULL REFERENCES Platnosc (IDPlatnosc),
  IDKlient           INT    NOT NULL REFERENCES Klient (IDKlient),
  DataPrzyjazd       DATE   NOT NULL,
  DataWyjazd         DATE   NOT NULL,
  DataRezerwacja     DATE   NOT NULL,
  Suma               INT    NOT NULL
);


/*==============================================================*/
/* Table: Pokoj_x_Rezerwacja                                    */
/*==============================================================*/

CREATE TABLE Pokoj_x_Rezerwacja
(
  IDRezerwacja INT NOT NULL REFERENCES Rezerwacja (IDRezerwacja),
  IDPokoj      INT NOT NULL REFERENCES Pokoj (IDPokoj),
  CenaPokoj    INT NOT NULL,
  PRIMARY KEY (IDRezerwacja, IDPokoj)
);


/*==============================================================*/
/* Table: klientHistoria                                        */
/*==============================================================*/

CREATE TABLE klientHistoria (
  id          SERIAL PRIMARY KEY,
  idKlient    INT  NOT NULL,
  imie        TEXT NOT NULL,
  nazwiko     TEXT NOT NULL,
  data_zmiany DATE NOT NULL
);

/*==============================================================*/
/* Table: adresHistoria                                        */
/*==============================================================*/

CREATE TABLE adresHistoria (
  id            SERIAL PRIMARY KEY,
  idAdres       INT  NOT NULL,
  Ulica         TEXT NOT NULL,
  Nr_domu       TEXT NOT NULL,
  Nr_Mieszkania TEXT NOT NULL,
  Miasto        TEXT NOT NULL,
  Kod_pocztowy  TEXT NOT NULL
);


INSERT INTO Adres VALUES (1, 'Długa', 5, 34, 'Poznań', '44-300');
INSERT INTO Adres VALUES (2, 'Daleka', 54, 66, 'Gdynia', '49-321');
INSERT INTO Adres VALUES (3, 'Siwa', 31, 43, 'Wrocłas', '34-323');

INSERT INTO Klient VALUES (1, 1, 'Jan', 'Nowak', '9010100293', '500493003', 'janek21313@wp.pl');
INSERT INTO Klient VALUES (2, 2, 'Juliusz', 'Cezar', '8810120293', '504939203', 'kulek123121@wp.pl');
INSERT INTO Klient VALUES (3, 3, 'Marta', 'Kownacka', '9105030293', '511493003', 'marta3421@gmail.pl');
INSERT INTO Klient VALUES (4, 1, 'Jan', 'Nowosielski', '9205030293', '521493003', 'jannowosielski2344@onet.pl');
INSERT INTO Klient VALUES (5, 2, 'Marta', 'Korycka', '9205030293', '503493003', 'martakorycka2349@wp.pl');

INSERT INTO Status_rezerwacji VALUES (1, 'Nowa');
INSERT INTO Status_rezerwacji VALUES (2, 'Zakończona');
INSERT INTO Status_rezerwacji VALUES (3, 'Anulowana');

INSERT INTO PlatnoscMetoda VALUES (1, 'Karta debetowa');
INSERT INTO PlatnoscMetoda VALUES (2, 'Karta kredytowa');
INSERT INTO PlatnoscMetoda VALUES (3, 'Gotówka');

INSERT INTO Platnosc VALUES (1, 1, 100, NOW());
INSERT INTO Platnosc VALUES (2, 2, 220, NOW());
INSERT INTO Platnosc VALUES (3, 3, 260, NOW());
INSERT INTO Platnosc VALUES (4, 3, 150, NOW());
INSERT INTO Platnosc VALUES (5, 2, 240, NOW());
INSERT INTO Platnosc VALUES (6, 2, 130, NOW());
INSERT INTO Platnosc VALUES (7, 3, 355, NOW());
INSERT INTO Platnosc VALUES (8, 2, 435, NOW());
INSERT INTO Platnosc VALUES (9, 2, 755, NOW());
INSERT INTO Platnosc VALUES (10, 1, 125, NOW());

INSERT INTO Rezerwacja VALUES (1, 1, 1, 3, NOW(), NOW(), NOW(), 120);
INSERT INTO Rezerwacja VALUES (2, 3, 2, 3, NOW(), NOW(), NOW(), 340);
INSERT INTO Rezerwacja VALUES (3, 1, 3, 3, NOW(), NOW(), NOW(), 110);
INSERT INTO Rezerwacja VALUES (4, 2, 4, 3, NOW(), NOW(), NOW(), 420);
INSERT INTO Rezerwacja VALUES (5, 3, 5, 3, NOW(), NOW(), NOW(), 490);
INSERT INTO Rezerwacja VALUES (6, 3, 6, 1, NOW(), NOW(), NOW(), 150);
INSERT INTO Rezerwacja VALUES (7, 3, 1, 1, NOW(), NOW(), NOW(), 90);
INSERT INTO Rezerwacja VALUES (8, 3, 3, 2, NOW(), NOW(), NOW(), 130);
INSERT INTO Rezerwacja VALUES (9, 1, 4, 2, NOW(), NOW(), NOW(), 175);
INSERT INTO Rezerwacja VALUES (10, 2, 1, 3, NOW(), NOW(), NOW(), 200);
INSERT INTO Rezerwacja VALUES (11, 3, 2, 4, NOW(), NOW(), NOW(), 140);
INSERT INTO Rezerwacja VALUES (12, 3, 3, 4, NOW(), NOW(), NOW(), 200);
INSERT INTO Rezerwacja VALUES (13, 2, 1, 4, NOW(), NOW(), NOW(), 220);
INSERT INTO Rezerwacja VALUES (14, 1, 5, 1, NOW(), NOW(), NOW(), 160);
INSERT INTO Rezerwacja VALUES (15, 1, 4, 5, NOW(), NOW(), NOW(), 120);

INSERT INTO PokojStatus VALUES (1, 'Zajęty', 'Pokój zajęty');
INSERT INTO PokojStatus VALUES (2, 'Wolny', 'Pokój wolny');
INSERT INTO PokojStatus VALUES (3, 'Zarezerwowany', 'Pokój zarezerwowany');

INSERT INTO Pokoj VALUES (1, 1, 3, 'Pokój trzyosobowy');
INSERT INTO Pokoj VALUES (2, 2, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (3, 2, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (4, 1, 5, 'Pokój pięcioosobowy');
INSERT INTO Pokoj VALUES (5, 1, 2, 'Pokój dwuosobowy');
INSERT INTO Pokoj VALUES (6, 2, 2, 'Pokój dwuosobowy');
INSERT INTO Pokoj VALUES (7, 1, 3, 'Pokój trzyosobowy');
INSERT INTO Pokoj VALUES (8, 3, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (9, 2, 5, 'Pokój pięcioosobowy');
INSERT INTO Pokoj VALUES (10, 1, 5, 'Pokój pięciioosobowy');

INSERT INTO PokojTyp VALUES (1, 'Zwykły', 1);
INSERT INTO PokojTyp VALUES (2, 'Premium', 2);
INSERT INTO PokojTyp VALUES (3, 'Nadzwyczajny', 3);

INSERT INTO Stawka VALUES (1, 1, 2, 200);
INSERT INTO Stawka VALUES (2, 2, 2, 200);
INSERT INTO Stawka VALUES (3, 3, 3, 200);

INSERT INTO Pokoj_x_Rezerwacja VALUES (1, 1, 420);
INSERT INTO Pokoj_x_Rezerwacja VALUES (1, 2, 120);
INSERT INTO Pokoj_x_Rezerwacja VALUES (2, 2, 135);
INSERT INTO Pokoj_x_Rezerwacja VALUES (2, 1, 200);
INSERT INTO Pokoj_x_Rezerwacja VALUES (3, 2, 150);


DROP VIEW IF EXISTS v_podstawoweInformacjeKlient;
DROP VIEW IF EXISTS v_liczbaDostepnychPokoiTyp;
DROP VIEW IF EXISTS v_emailKlientLiczbaRezerwacji;


/*==============================================================*/
/* View: v_podstawoweInformacjeKlient                           */
/*==============================================================*/

CREATE VIEW v_podstawoweInformacjeKlient AS
  SELECT
    k.Imie,
    k.Nazwisko,
    adres.miasto
  FROM klient k
    LEFT JOIN adres ON k.IDAdres = adres.IDAdres
  ORDER BY k.Nazwisko ASC;


/*==============================================================*/
/* view: v_liczbaDostepnychPokoiTyp                             */
/*==============================================================*/

CREATE VIEW v_liczbaDostepnychPokoiTyp AS
  SELECT
    ps.opisstatusu,
    COUNT(pt.opis)
  FROM pokoj p
    LEFT JOIN stawka s ON s.idpokoj = p.idpokoj
    LEFT JOIN pokojtyp pt ON p.IDPokoj = s.IDPokojTyp
    LEFT JOIN pokojstatus ps ON p.IDPokojStatus = ps.IDPokojStatus
  WHERE ps.IDPokojStatus = 2
  GROUP BY (ps.opisstatusu);


/*==============================================================*/
/* view: v_emailKlientLiczbaRezerwacji                          */
/*==============================================================*/

CREATE VIEW v_emailKlientLiczbaRezerwacji AS
  SELECT
    k.email,
    COUNT(r.IDRezerwacja) "ilosc rezerwacji"
  FROM klient k
    LEFT JOIN rezerwacja r ON k.idklient = r.IDKlient
  GROUP BY (k.email)
  ORDER BY ("ilosc rezerwacji") DESC;


DROP FUNCTION IF EXISTS zaloguj_zmiane_imienia_lub_nazwiska();
DROP FUNCTION IF EXISTS zaloguj_zmiane_adresu();

DROP TRIGGER IF EXISTS zmiana_imienia_lub_nazwiska ON klient;
DROP TRIGGER IF EXISTS zmiana_adresu ON adres;


/*==============================================================*/
/* function: zaloguj_zmiane_imienia_lub_nazwiska()              */
/*==============================================================*/

CREATE OR REPLACE FUNCTION zaloguj_zmiane_imienia_lub_nazwiska()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  INSERT INTO klienthistoria (idKlient, imie, nazwiko, data_zmiany)
  VALUES (OLD.idKlient, OLD.imie, OLD.nazwisko, now());
  RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;


/*==============================================================*/
/* viewfunction: zaloguj_zmiane_adresu()                        */
/*==============================================================*/

CREATE OR REPLACE FUNCTION zaloguj_zmiane_adresu()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  INSERT INTO adreshistoria (idadres, ulica, nr_domu, nr_mieszkania, miasto, kod_pocztowy)
  VALUES (OLD.idadres, OLD.ulica, OLD.nr_domu, OLD.nr_mieszkania, OLD.miasto, now());
  RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;


/*==============================================================*/
/* trigger: zmiana_imienia_lub_nazwiska                         */
/*==============================================================*/

CREATE TRIGGER zmiana_imienia_lub_nazwiska
BEFORE UPDATE
ON klient
FOR EACH ROW
EXECUTE PROCEDURE zaloguj_zmiane_imienia_lub_nazwiska();


/*==============================================================*/
/* trigger: zmiana_adresu                                       */
/*==============================================================*/

CREATE TRIGGER zmiana_adresu
BEFORE UPDATE
ON adres
FOR EACH ROW
EXECUTE PROCEDURE zaloguj_zmiane_adresu();
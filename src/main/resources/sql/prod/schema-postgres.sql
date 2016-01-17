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

/*==============================================================*/
/* Table: Adres                                                 */
/*==============================================================*/
CREATE TABLE Adres
(
  IDAdres       SERIAL NOT NULL,
  Ulica         TEXT   NOT NULL,
  Nr_domu       TEXT   NOT NULL,
  Nr_Mieszkania TEXT   NOT NULL,
  Miasto        TEXT   NOT NULL,
  Kod_pocztowy  TEXT   NOT NULL,
  PRIMARY KEY (IDAdres)
);

/*==============================================================*/
/* Table: Klient                                                */
/*==============================================================*/
CREATE TABLE Klient
(
  IDKlient SERIAL NOT NULL,
  IDAdres  INT    NOT NULL,
  Imie     TEXT   NOT NULL,
  Nazwisko TEXT   NOT NULL,
  PESEL    TEXT   NOT NULL CHECK (length(PESEL) IN (11)),
  Telefon  TEXT   NOT NULL,
  Email    TEXT   NOT NULL,
  PRIMARY KEY (IDKlient)
);

/*==============================================================*/
/* Table: Platnosc                                              */
/*==============================================================*/
CREATE TABLE Platnosc
(
  IDPlatnosc       SERIAL NOT NULL,
  IDPlatnoscMetoda INT    NOT NULL,
  Wartosc          INT    NOT NULL,
  DataPlatnosci    DATE   NOT NULL,
  PRIMARY KEY (IDPlatnosc)
);

/*==============================================================*/
/* Table: PlatnoscMetoda                                        */
/*==============================================================*/
CREATE TABLE PlatnoscMetoda
(
  IDPlatnoscMetoda SERIAL NOT NULL,
  Nazwa            TEXT   NOT NULL,
  PRIMARY KEY (IDPlatnoscMetoda)
);

/*==============================================================*/
/* Table: Pokoj                                                 */
/*==============================================================*/
CREATE TABLE Pokoj
(
  IDPokoj       SERIAL NOT NULL,
  IDPokojStatus INT    NOT NULL,
  LiczbaOsob    INT    NOT NULL,
  PRIMARY KEY (IDPokoj)
);

/*==============================================================*/
/* Table: Pokoj_x_Rezerwacja                                    */
/*==============================================================*/
CREATE TABLE Pokoj_x_Rezerwacja
(
  IDRezerwacja INT NOT NULL,
  IDPokoj      INT NOT NULL,
  CenaPokoj    INT NOT NULL,
  PRIMARY KEY (IDRezerwacja, IDPokoj)
);

/*==============================================================*/
/* Table: PokojStatus                                           */
/*==============================================================*/
CREATE TABLE PokojStatus
(
  IDPokojStatus SERIAL NOT NULL,
  Opis          TEXT   NOT NULL,
  PRIMARY KEY (IDPokojStatus)
);

/*==============================================================*/
/* Table: PokojTyp                                              */
/*==============================================================*/
CREATE TABLE PokojTyp
(
  IDPokojTyp SERIAL NOT NULL,
  Opis       TEXT   NOT NULL,
  Mnoznik    FLOAT  NOT NULL,
  PRIMARY KEY (IDPokojTyp)
);

/*==============================================================*/
/* Table: Rezerwacja                                            */
/*==============================================================*/
CREATE TABLE Rezerwacja
(
  IDRezerwacja       SERIAL NOT NULL,
  IDStatusRezerwacja INT    NOT NULL,
  IDPlatnosc         INT    NOT NULL,
  IDKlient           INT    NOT NULL,
  DataPrzyjazd       DATE   NOT NULL,
  DataWyjazd         DATE   NOT NULL,
  DataRezerwacja     DATE   NOT NULL,
  Suma               INT    NOT NULL,
  PRIMARY KEY (IDRezerwacja)
);

/*==============================================================*/
/* Table: Status_Rezerwacji                                     */
/*==============================================================*/
CREATE TABLE Status_Rezerwacji
(
  IDStatusRezerwacja SERIAL NOT NULL,
  Status_Rezerwacji  TEXT   NOT NULL,
  PRIMARY KEY (IDStatusRezerwacja)
);

/*==============================================================*/
/* Table: Stawka                                                */
/*==============================================================*/
CREATE TABLE Stawka
(
  IDStawka         SERIAL NOT NULL,
  IDPokoj          INT    NOT NULL,
  IDPokojTyp       INT    NOT NULL,
  StawkaPodstawowa INT    NOT NULL,
  PRIMARY KEY (IDStawka)
);

ALTER TABLE Klient ADD CONSTRAINT FK_Relationship_1 FOREIGN KEY (IDAdres)
REFERENCES Adres (IDAdres) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Platnosc ADD CONSTRAINT FK_Relationship_2 FOREIGN KEY (IDPlatnoscMetoda)
REFERENCES PlatnoscMetoda (IDPlatnoscMetoda) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Pokoj ADD CONSTRAINT FK_Relationship_3 FOREIGN KEY (IDPokojStatus)
REFERENCES PokojStatus (IDPokojStatus) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Rezerwacja ADD CONSTRAINT FK_Relationship_4 FOREIGN KEY (IDKlient)
REFERENCES Klient (IDKlient) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Rezerwacja ADD CONSTRAINT FK_Relationship_5 FOREIGN KEY (IDStatusRezerwacja)
REFERENCES Status_Rezerwacji (IDStatusRezerwacja) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Rezerwacja ADD CONSTRAINT FK_Relationship_6 FOREIGN KEY (IDPlatnosc)
REFERENCES Platnosc (IDPlatnosc) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Stawka ADD CONSTRAINT FK_Relationship_7 FOREIGN KEY (IDPokojTyp)
REFERENCES PokojTyp (IDPokojTyp) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Stawka ADD CONSTRAINT FK_Relationship_8 FOREIGN KEY (IDPokoj)
REFERENCES Pokoj (IDPokoj) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Pokoj_x_Rezerwacja ADD CONSTRAINT FK_Relationship_9 FOREIGN KEY (IDRezerwacja)
REFERENCES Rezerwacja (IDRezerwacja) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Pokoj_x_Rezerwacja ADD CONSTRAINT FK_Relationship_10 FOREIGN KEY (IDPokoj)
REFERENCES Pokoj (IDPokoj) ON DELETE RESTRICT ON UPDATE RESTRICT;

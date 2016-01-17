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
  IDAdres       INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Ulica         TEXT NOT NULL,
  Nr_domu       TEXT NOT NULL,
  Nr_Mieszkania TEXT NOT NULL,
  Miasto        TEXT NOT NULL,
  Kod_pocztowy  TEXT NOT NULL
);

/*==============================================================*/
/* Table: Klient                                                */
/*==============================================================*/
CREATE TABLE Klient
(
  IDKlient INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDAdres  INT  NOT NULL,
  Imie     TEXT NOT NULL,
  Nazwisko TEXT NOT NULL,
  PESEL    TEXT NOT NULL,
  Telefon  TEXT NOT NULL,
  Email    TEXT NOT NULL
);

/*==============================================================*/
/* Table: Platnosc                                              */
/*==============================================================*/
CREATE TABLE Platnosc
(
  IDPlatnosc       INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDPlatnoscMetoda INT  NOT NULL,
  Wartosc          INT  NOT NULL,
  DataPlatnosci    DATE NOT NULL
);

/*==============================================================*/
/* Table: PlatnoscMetoda                                        */
/*==============================================================*/
CREATE TABLE PlatnoscMetoda
(
  IDPlatnoscMetoda INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Nazwa            TEXT NOT NULL
);

/*==============================================================*/
/* Table: Pokoj                                                 */
/*==============================================================*/
CREATE TABLE Pokoj
(
  IDPokoj       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDPokojStatus INT NOT NULL,
  LiczbaOsob    INT NOT NULL
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
  IDPokojStatus INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Opis          TEXT NOT NULL
);

/*==============================================================*/
/* Table: PokojTyp                                              */
/*==============================================================*/
CREATE TABLE PokojTyp
(
  IDPokojTyp INT   NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Opis       TEXT  NOT NULL,
  Mnoznik    FLOAT NOT NULL
);

/*==============================================================*/
/* Table: Rezerwacja                                            */
/*==============================================================*/
CREATE TABLE Rezerwacja
(
  IDRezerwacja       INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDStatusRezerwacja INT  NOT NULL,
  IDPlatnosc         INT  NOT NULL,
  IDKlient           INT  NOT NULL,
  DataPrzyjazd       DATE NOT NULL,
  DataWyjazd         DATE NOT NULL,
  DataRezerwacja     DATE NOT NULL,
  Suma               INT  NOT NULL
);

/*==============================================================*/
/* Table: Status_Rezerwacji                                     */
/*==============================================================*/
CREATE TABLE Status_Rezerwacji
(
  IDStatusRezerwacja INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Status_Rezerwacji  TEXT NOT NULL
);

/*==============================================================*/
/* Table: Stawka                                                */
/*==============================================================*/
CREATE TABLE Stawka
(
  IDStawka         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDPokoj          INT NOT NULL,
  IDPokojTyp       INT NOT NULL,
  StawkaPodstawowa INT NOT NULL
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
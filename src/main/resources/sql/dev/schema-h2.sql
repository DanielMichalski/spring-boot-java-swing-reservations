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
  IDAdres  INT  NOT NULL REFERENCES Adres(IDAdres),
  Imie     TEXT NOT NULL,
  Nazwisko TEXT NOT NULL,
  PESEL    TEXT NOT NULL,
  Telefon  TEXT NOT NULL,
  Email    TEXT NOT NULL
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
/* Table: Platnosc                                              */
/*==============================================================*/
CREATE TABLE Platnosc
(
  IDPlatnosc       INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDPlatnoscMetoda INT  NOT NULL REFERENCES PlatnoscMetoda(IDPlatnoscMetoda),
  Wartosc          INT  NOT NULL,
  DataPlatnosci    DATE NOT NULL
);

/*==============================================================*/
/* Table: PokojStatus                                           */
/*==============================================================*/
CREATE TABLE PokojStatus
(
  IDPokojStatus INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  StatusPokoju  TEXT   NOT NULL,
  OpisStatusu   TEXT   NOT NULL
);

/*==============================================================*/
/* Table: Pokoj                                                 */
/*==============================================================*/
CREATE TABLE Pokoj
(
  IDPokoj       INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDPokojStatus INT NOT NULL REFERENCES PokojStatus(IDPokojStatus),
  LiczbaOsob    INT    NOT NULL,
  Opis          TEXT   NOT NULL
);

/*==============================================================*/
/* Table: PokojTyp                                              */
/*==============================================================*/
CREATE TABLE PokojTyp
(
  IDPokojTyp INT   NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Opis       TEXT  NOT NULL,
  Mnoznik    INT NOT NULL
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
  IDPokoj          INT NOT NULL REFERENCES Pokoj(IDPokoj),
  IDPokojTyp       INT NOT NULL REFERENCES PokojTyp(IDPokojTyp),
  StawkaPodstawowa INT NOT NULL
);

/*==============================================================*/
/* Table: Rezerwacja                                            */
/*==============================================================*/
CREATE TABLE Rezerwacja
(
  IDRezerwacja       INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDStatusRezerwacja INT  NOT NULL REFERENCES Status_Rezerwacji(IDStatusRezerwacja),
  IDPlatnosc         INT  NOT NULL REFERENCES Platnosc(IDPlatnosc),
  IDKlient           INT  NOT NULL REFERENCES Klient(IDKlient),
  DataPrzyjazd       DATE NOT NULL,
  DataWyjazd         DATE NOT NULL,
  DataRezerwacja     DATE NOT NULL,
  Suma               INT  NOT NULL
);


/*==============================================================*/
/* Table: Pokoj_x_Rezerwacja                                    */
/*==============================================================*/
CREATE TABLE Pokoj_x_Rezerwacja
(
  IDRezerwacja INT NOT NULL REFERENCES Rezerwacja(IDRezerwacja),
  IDPokoj      INT NOT NULL REFERENCES Pokoj(IDPokoj),
  CenaPokoj    INT NOT NULL,
  PRIMARY KEY (IDRezerwacja, IDPokoj)
);
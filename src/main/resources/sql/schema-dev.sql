DROP ALL OBJECTS;

----------------------------------------------------------------------------
--   Kient                                                                 |
----------------------------------------------------------------------------

CREATE TABLE Klient
(
  IDKlient             INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  IDAdres              INT,
  Imie                 TEXT NOT NULL,
  Nazwisko             TEXT NOT NULL,
  PESEL                TEXT NOT NULL,
  Telefon              TEXT,
  Email                TEXT
);
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
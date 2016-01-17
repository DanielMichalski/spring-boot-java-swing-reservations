/*==============================================================*/
/* TRIGGER: STAWKA                                              */
/*==============================================================*/

DELIMITER $$
CREATE TRIGGER `liczMnoznik` BEFORE INSERT ON `stawka`
 FOR EACH ROW BEGIN
set @mnoznikPokojTyp  = (
    SELECT pokojtyp.Mnoznik
    From pokojtyp
    WHERE pokojtyp.IDPokojTyp = NEW.IDPokojTyp
    );
set @mnoznikSezon  = (
    SELECT sezon.Mnoznik
    From sezon
    WHERE sezon.IDSezon = NEW.IDSezon
    ) ;
SET NEW.Mnoznik = 1;
SET NEW.Mnoznik = NEW.Mnoznik*@mnoznikPokojTyp*@mnoznikSezon;
END $$
DELIMITER $$;

/*==============================================================*/
/* TRIGGER: POKOJ                                       */
/*==============================================================*/

DELIMITER $$
CREATE TRIGGER `liczCenaPokoj` BEFORE INSERT ON `pokoj`
 FOR EACH ROW BEGIN
set @mnoznik  = (
    SELECT stawka.Mnoznik
    From stawka
    WHERE stawka.IDStawka=NEW.IDStawka
    );

SET NEW.CenaPokoj = NEW.CenaPokojPodstawa*@mnoznik;
END $$
DELIMITER $$;

/*==============================================================*/
/* FUNCKJA: liczSumaCalkowita                             */
/*==============================================================*/

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `liczSumaCalkowita`(IN `newID` INT)
    NO SQL
BEGIN
SET @suma = (SELECT SUM(encja.Suma) as Suma
		FROM (

		SELECT pokojpozycja.IDRezerwacja,SUM(pokoj.CenaPokoj) as Suma
					FROM `pokojpozycja`
					LEFT JOIN pokoj on pokoj.IDPokoj = pokojpozycja.IDPokoj
					GROUP BY  pokojpozycja.IDRezerwacja
					HAVING  pokojpozycja.IDRezerwacja = newID
		UNION

		SELECT uslugapozycja.IDRezerwacja , SUM(usluga.CenaUsluga) as Suma
					FROM `uslugapozycja`
					LEFT JOIN usluga on usluga.IDUsluga = uslugapozycja.IDUsluga
					GROUP BY (uslugapozycja.IDRezerwacja)
					HAVING uslugapozycja.IDRezerwacja = newID
				  )AS encja
				  GROUP by (encja.IDRezerwacja)
             );

             UPDATE `rezerwacja`
SET `Suma`=IFNULL(
    @suma,0)
WHERE newID = rezerwacja.IDRezerwacja;

END $$
DELIMITER $$;

/*==============================================================*/
/* TRIGGER: POKOJPOZYCJA                                       */
/*==============================================================*/


CREATE TRIGGER `liczSumaPokojInsert`
after  INSERT  ON `pokojpozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(NEW.IDRezerwacja);

CREATE TRIGGER `liczSumaPokojUpdate`
after  UPDATE  ON `pokojpozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(NEW.IDRezerwacja);

 CREATE TRIGGER `liczSumaPokojDelete`
after  DELETE  ON `pokojpozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(OLD.IDRezerwacja);


/*==============================================================*/
/* TRIGGER: USLUGAPOZYCJA                                       */
/*==============================================================*/


CREATE TRIGGER `liczSumaUslugaInsert`
after  INSERT ON `uslugapozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(NEW.IDRezerwacja);

CREATE TRIGGER `liczSumaUslugaUpdate`
after UPDATE ON `uslugapozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(NEW.IDRezerwacja);

 CREATE TRIGGER `liczSumaUslugaDelete`
after DELETE ON `uslugapozycja`
 FOR EACH ROW CALL `liczSumaCalkowita`(OLD.IDRezerwacja);




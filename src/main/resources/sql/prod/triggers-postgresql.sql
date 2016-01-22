DROP FUNCTION IF EXISTS log_client_data_changed();
DROP FUNCTION IF EXISTS log_address_changed();

DROP TRIGGER IF EXISTS changing_client_data ON client;
DROP TRIGGER IF EXISTS changing_address ON address;


/*==============================================================*/
/* function: log_client_data_changed()                          */
/*==============================================================*/

CREATE OR REPLACE FUNCTION log_client_data_changed()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  INSERT INTO client_history (client_id, name, surname, change_date)
  VALUES (OLD.id_client, OLD.name, OLD.surname, now());
  RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;


/*==============================================================*/
/* viewfunction: log_address_changed()                          */
/*==============================================================*/

CREATE OR REPLACE FUNCTION log_address_changed()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  INSERT INTO address_history (id_address, street, house_number, flat_number, city, postal_code, change_date)
  VALUES (OLD.id_address, OLD.street, OLD.house_number, OLD.flat_number, OLD.city, postal_code, now());
  RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;


/*==============================================================*/
/* trigger: changing_client_data                                */
/*==============================================================*/

CREATE TRIGGER changing_client_data
BEFORE UPDATE
ON client
FOR EACH ROW
EXECUTE PROCEDURE log_client_data_changed();


/*==============================================================*/
/* trigger: changing_address                                    */
/*==============================================================*/

CREATE TRIGGER changing_address
BEFORE UPDATE
ON address
FOR EACH ROW
EXECUTE PROCEDURE log_address_changed();
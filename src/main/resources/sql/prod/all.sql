/*==============================================================*/

DROP TABLE IF EXISTS address CASCADE;

DROP TABLE IF EXISTS client CASCADE;

DROP TABLE IF EXISTS payment CASCADE;

DROP TABLE IF EXISTS payment_method CASCADE;

DROP TABLE IF EXISTS room CASCADE;

DROP TABLE IF EXISTS room_x_reservation CASCADE;

DROP TABLE IF EXISTS room_status CASCADE;

DROP TABLE IF EXISTS room_type CASCADE;

DROP TABLE IF EXISTS reservation CASCADE;

DROP TABLE IF EXISTS reservation_status CASCADE;

DROP TABLE IF EXISTS rate CASCADE;

DROP TABLE IF EXISTS client_history CASCADE;

DROP TABLE IF EXISTS address_history CASCADE;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
CREATE TABLE address
(
  id_address   SERIAL NOT NULL PRIMARY KEY,
  street       TEXT   NOT NULL,
  house_number TEXT   NOT NULL,
  flat_number  TEXT   NOT NULL,
  city         TEXT   NOT NULL,
  postal_code  TEXT   NOT NULL
);

/*==============================================================*/
/* Table: client                                                */
/*==============================================================*/
CREATE TABLE client
(
  id_client    SERIAL NOT NULL PRIMARY KEY,
  id_address   INT    NOT NULL REFERENCES address (id_address),
  name         TEXT   NOT NULL,
  surname      TEXT   NOT NULL,
  PESEL        TEXT   NOT NULL,
  phone_number TEXT   NOT NULL,
  mail         TEXT   NOT NULL
);

/*==============================================================*/
/* Table: payment_method                                        */
/*==============================================================*/
CREATE TABLE payment_method
(
  id_payment_method SERIAL NOT NULL PRIMARY KEY,
  name              TEXT   NOT NULL
);

/*==============================================================*/
/* Table: payment                                               */
/*==============================================================*/
CREATE TABLE payment
(
  id_payment        SERIAL NOT NULL PRIMARY KEY,
  id_payment_method INT    NOT NULL REFERENCES payment_method (id_payment_method),
  value             INT    NOT NULL,
  date_of_payment   DATE   NOT NULL
);

/*==============================================================*/
/* Table: room_status                                           */
/*==============================================================*/
CREATE TABLE room_status
(
  id_room_status     SERIAL NOT NULL PRIMARY KEY,
  room_status        TEXT   NOT NULL,
  status_description TEXT   NOT NULL
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
CREATE TABLE room
(
  id_room          SERIAL NOT NULL PRIMARY KEY,
  id_room_status   INT    NOT NULL REFERENCES room_status (id_room_status),
  number_of_people INT    NOT NULL,
  description      TEXT   NOT NULL
);

/*==============================================================*/
/* Table: room_type                                             */
/*==============================================================*/
CREATE TABLE room_type
(
  id_room_type SERIAL NOT NULL PRIMARY KEY,
  description  TEXT   NOT NULL,
  multiplier   INT    NOT NULL
);

/*==============================================================*/
/* Table: reservation_status                                    */
/*==============================================================*/
CREATE TABLE reservation_status
(
  id_reservation_status SERIAL NOT NULL PRIMARY KEY,
  reservation_status    TEXT   NOT NULL
);

/*==============================================================*/
/* Table: rate                                                  */
/*==============================================================*/
CREATE TABLE rate
(
  id_rate      SERIAL NOT NULL PRIMARY KEY,
  id_room      INT    NOT NULL REFERENCES room (id_room),
  id_room_type INT    NOT NULL REFERENCES room_type (id_room_type),
  default_rate INT    NOT NULL
);

/*==============================================================*/
/* Table: reservation                                           */
/*==============================================================*/
CREATE TABLE reservation
(
  id_reservation        SERIAL NOT NULL PRIMARY KEY,
  id_resrevation_status INT    NOT NULL REFERENCES reservation_status (id_reservation_status),
  id_payment            INT    NOT NULL REFERENCES payment (id_payment),
  id_client             INT    NOT NULL REFERENCES client (id_client),
  from_date             DATE   NOT NULL,
  to_date               DATE   NOT NULL,
  reservation_date      DATE   NOT NULL,
  amount                INT    NOT NULL
);

/*==============================================================*/
/* Table: room_x_reservation                                    */
/*==============================================================*/
CREATE TABLE room_x_reservation
(
  id_reservation SERIAL NOT NULL REFERENCES reservation (id_reservation),
  id_room        INT    NOT NULL REFERENCES room (id_room),
  room_price     INT    NOT NULL,
  PRIMARY KEY (id_reservation, id_room)
);

/*==============================================================*/
/* Table: client_history                                        */
/*==============================================================*/
CREATE TABLE client_history (
  id          SERIAL NOT NULL PRIMARY KEY,
  client_id   INT    NOT NULL REFERENCES client (id_client),
  name        TEXT   NOT NULL,
  surname     TEXT   NOT NULL,
  change_date DATE   NOT NULL
);

/*==============================================================*/
/* Table: address_history                                       */
/*==============================================================*/
CREATE TABLE address_history (
  id           SERIAL NOT NULL PRIMARY KEY,
  id_address   INT    NOT NULL REFERENCES address (id_address),
  street       TEXT   NOT NULL,
  house_number TEXT   NOT NULL,
  flat_number  TEXT   NOT NULL,
  city         TEXT   NOT NULL,
  postal_code  TEXT   NOT NULL,
  change_date DATE   NOT NULL
);


INSERT INTO address VALUES (1, 'Long', 5, 34, 'New York', '44-300');
INSERT INTO address VALUES (2, 'Long streen', 54, 66, 'Paris', '49-321');
INSERT INTO address VALUES (3, '18 Street', 31, 43, 'Sydney', '34-323');

INSERT INTO client VALUES (1, 1, 'John', 'New', '9010100293', '500493003', 'janek21313@oc.eu');
INSERT INTO client VALUES (2, 2, 'Mark', 'Spencer', '8810120293', '504939203', 'kulek123121@oc.eu');
INSERT INTO client VALUES (3, 3, 'Jules', 'Black', '9105030293', '511493003', 'marta3421@oc.eu');
INSERT INTO client VALUES (4, 1, 'Maria', 'White', '9205030293', '521493003', 'jannowosielski2344@oc.eu');
INSERT INTO client VALUES (5, 2, 'Paris', 'Mary', '9205030293', '503493003', 'martakorycka2349@oc.eu');

INSERT INTO reservation_status VALUES (1, 'New');
INSERT INTO reservation_status VALUES (2, 'Finished');
INSERT INTO reservation_status VALUES (3, 'Canceled');

INSERT INTO payment_method VALUES (1, 'Debit card');
INSERT INTO payment_method VALUES (2, 'Credit card');
INSERT INTO payment_method VALUES (3, 'Cash');

INSERT INTO payment VALUES (1, 1, 100, NOW());
INSERT INTO payment VALUES (2, 2, 220, NOW());
INSERT INTO payment VALUES (3, 3, 260, NOW());
INSERT INTO payment VALUES (4, 3, 150, NOW());
INSERT INTO payment VALUES (5, 2, 240, NOW());
INSERT INTO payment VALUES (6, 2, 130, NOW());
INSERT INTO payment VALUES (7, 3, 355, NOW());
INSERT INTO payment VALUES (8, 2, 435, NOW());
INSERT INTO payment VALUES (9, 2, 755, NOW());
INSERT INTO payment VALUES (10, 1, 125, NOW());

INSERT INTO reservation VALUES (1, 1, 1, 3, NOW(), NOW(), NOW(), 120);
INSERT INTO reservation VALUES (2, 3, 2, 3, NOW(), NOW(), NOW(), 340);
INSERT INTO reservation VALUES (3, 1, 3, 3, NOW(), NOW(), NOW(), 110);
INSERT INTO reservation VALUES (4, 2, 4, 3, NOW(), NOW(), NOW(), 420);
INSERT INTO reservation VALUES (5, 3, 5, 3, NOW(), NOW(), NOW(), 490);
INSERT INTO reservation VALUES (6, 3, 6, 1, NOW(), NOW(), NOW(), 150);
INSERT INTO reservation VALUES (7, 3, 1, 1, NOW(), NOW(), NOW(), 90);
INSERT INTO reservation VALUES (8, 3, 3, 2, NOW(), NOW(), NOW(), 130);
INSERT INTO reservation VALUES (9, 1, 4, 2, NOW(), NOW(), NOW(), 175);
INSERT INTO reservation VALUES (10, 2,1, 3, NOW(), NOW(), NOW(), 200);
INSERT INTO reservation VALUES (11, 3, 2, 4, NOW(), NOW(), NOW(), 140);
INSERT INTO reservation VALUES (12, 3, 3, 4, NOW(), NOW(), NOW(), 200);
INSERT INTO reservation VALUES (13, 2, 1, 4, NOW(), NOW(), NOW(), 220);
INSERT INTO reservation VALUES (14, 1, 5, 1, NOW(), NOW(), NOW(), 160);
INSERT INTO reservation VALUES (15, 1, 4, 5, NOW(), NOW(), NOW(), 120);

INSERT INTO room_status VALUES (1, 'Not empty', 'Room not empty');
INSERT INTO room_status VALUES (2, 'Empty', 'Room empty');
INSERT INTO room_status VALUES (3, 'Reserved', 'Room reserved');

INSERT INTO room VALUES (1, 1, 3, 'A triple room');
INSERT INTO room VALUES (2, 2, 4, 'Four-person room');
INSERT INTO room VALUES (3, 2, 4, 'Four-person room');
INSERT INTO room VALUES (4, 1, 5, 'Five-person room');
INSERT INTO room VALUES (5, 1, 2, 'Double room');
INSERT INTO room VALUES (6, 2, 2, 'Double room');
INSERT INTO room VALUES (7, 1, 3, 'A triple room');
INSERT INTO room VALUES (8, 3, 4, 'Four-person room');
INSERT INTO room VALUES (9, 2, 5, 'Five-person room');
INSERT INTO room VALUES (10, 1, 5, 'Five-person room');

INSERT INTO room_type VALUES (1, 'Basic', 1);
INSERT INTO room_type VALUES (2, 'Premium', 2);
INSERT INTO room_type VALUES (3, 'Luxury', 3);

INSERT INTO rate VALUES (1, 1, 2, 200);
INSERT INTO rate VALUES (2, 2, 2, 200);
INSERT INTO rate VALUES (3, 3, 3, 200);

INSERT INTO room_x_reservation VALUES (1, 1, 420);
INSERT INTO room_x_reservation VALUES (1, 2, 120);
INSERT INTO room_x_reservation VALUES (2, 2, 135);
INSERT INTO room_x_reservation VALUES (2, 1, 200);
INSERT INTO room_x_reservation VALUES (3, 2, 150);


DROP VIEW IF EXISTS v_client_basic_information;
DROP VIEW IF EXISTS v_number_of_empty_rooms;
DROP VIEW IF EXISTS v_client_reservations;


/*==============================================================*/
/* View: v_client_basic_information                             */
/*==============================================================*/

CREATE VIEW v_client_basic_information AS
  SELECT
    c.name,
    c.surname,
    a.city
  FROM client c
    LEFT JOIN address a ON c.id_address = a.id_address
  ORDER BY c.name ASC;


/*==============================================================*/
/* view: v_number_of_empty_rooms                                */
/*==============================================================*/

CREATE VIEW v_number_of_empty_rooms AS
  SELECT
    rs.status_description,
    COUNT(r_type.description)
  FROM room r
    LEFT JOIN rate rt ON rt.id_room = r.id_room
    LEFT JOIN room_type r_type ON r.id_room = rt.id_room_type
    LEFT JOIN room_status rs ON r.id_room_status = rs.id_room_status
  WHERE rs.id_room_status = 2
  GROUP BY (rs.status_description);


/*==============================================================*/
/* view: v_client_reservations                                  */
/*==============================================================*/

CREATE VIEW v_client_reservations as
  SELECT
    c.mail,
    COUNT(r.id_reservation) "Number of reservartions"
  FROM client c
    LEFT JOIN reservation r ON c.id_client = r.id_client
  GROUP BY (c.mail)
  ORDER BY ("Number of reservartions") DESC;


DROP FUNCTION IF EXISTS log_client_data_changed();
DROP FUNCTION IF EXISTS log_address_changed();

DROP TRIGGER IF EXISTS changing_client_data ON client;
DROP TRIGGER IF EXISTS changing_address ON address;


/*==============================================================*/
/* function: log_client_data_changed()                          */
/*==============================================================*/

CREATE OR REPLACE FUNCTION zaloguj_zmiane_imienia_lub_nazwiska()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  INSERT INTO klient_history (client_id, name, surname, change_date)
  VALUES (OLD.client_id, OLD.name, OLD.surname, now());
  RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;


/*==============================================================*/
/* viewfunction: log_address_changed()                          */
/*==============================================================*/

CREATE OR REPLACE FUNCTION zaloguj_zmiane_adresu()
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
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

CREATE INDEX address_city_index ON address(city);

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

CREATE INDEX client_id_address_index ON client(id_address);
CREATE INDEX client_PESEL_index ON client(PESEL);
CREATE INDEX client_phone_number_index ON client(phone_number);

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

CREATE INDEX payment_id_payment_method_index ON payment(id_payment_method);

/*==============================================================*/
/* Table: room_status                                           */
/*==============================================================*/
CREATE TABLE room_status
(
  id_room_status     SERIAL NOT NULL PRIMARY KEY,
  room_status        TEXT   NOT NULL,
  status_description TEXT   NOT NULL
);

CREATE INDEX room_status_room_status_index ON room_status(room_status);

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

CREATE INDEX room_id_room_status_index ON room(id_room_status);

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

CREATE INDEX reservation_status_reservation_status_index ON reservation_status(reservation_status);

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

CREATE INDEX rate_id_room_index ON rate(id_room);
CREATE INDEX rate_id_room_type_index ON rate(id_room_type);

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

CREATE INDEX reservation_id_resrevation_status_index ON reservation(id_resrevation_status);
CREATE INDEX reservation_id_payment_index ON reservation(id_payment);
CREATE INDEX reservation_id_client_index ON reservation(id_client);
CREATE INDEX reservation_from_date_index ON reservation(from_date);
CREATE INDEX reservation_to_date_index ON reservation(to_date);

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

CREATE INDEX room_x_reservation_id_room_index ON room_x_reservation(id_room);

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

CREATE INDEX client_history_client_id_index ON client_history(client_id);
CREATE INDEX client_history_name_index ON client_history(name);
CREATE INDEX client_history_surname_index ON client_history(surname);

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

CREATE INDEX address_history_id_address_index ON address_history(id_address);
CREATE INDEX address_history_city_index ON address_history(city);

INSERT INTO address VALUES (nextval('address_id_address_seq'), 'Long', '5', '34', 'New York', '44-300');
INSERT INTO address VALUES (nextval('address_id_address_seq'), 'Long streen', '54', '66', 'Paris', '49-321');
INSERT INTO address VALUES (nextval('address_id_address_seq'), '18 Street', '31', '43', 'Sydney', '34-323');

INSERT INTO client VALUES (nextval('client_id_client_seq'), 1, 'John', 'New', '9010100293', '500493003', 'janek21313@oc.eu');
INSERT INTO client VALUES (nextval('client_id_client_seq'), 2, 'Mark', 'Spencer', '8810120293', '504939203', 'kulek123121@oc.eu');
INSERT INTO client VALUES (nextval('client_id_client_seq'), 3, 'Jules', 'Black', '9105030293', '511493003', 'marta3421@oc.eu');
INSERT INTO client VALUES (nextval('client_id_client_seq'), 1, 'Maria', 'White', '9205030293', '521493003', 'jannowosielski2344@oc.eu');
INSERT INTO client VALUES (nextval('client_id_client_seq'), 2, 'Paris', 'Mary', '9205030293', '503493003', 'martakorycka2349@oc.eu');

INSERT INTO reservation_status VALUES (nextval('reservation_status_id_reservation_status_seq'), 'New');
INSERT INTO reservation_status VALUES (nextval('reservation_status_id_reservation_status_seq'), 'Finished');
INSERT INTO reservation_status VALUES (nextval('reservation_status_id_reservation_status_seq'), 'Canceled');

INSERT INTO payment_method VALUES (nextval('payment_method_id_payment_method_seq'), 'Debit card');
INSERT INTO payment_method VALUES (nextval('payment_method_id_payment_method_seq'), 'Credit card');
INSERT INTO payment_method VALUES (nextval('payment_method_id_payment_method_seq'), 'Cash');

INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 1, 100, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 2, 220, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 3, 260, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 3, 150, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 2, 240, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 2, 130, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 3, 355, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 2, 435, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 2, 755, NOW());
INSERT INTO payment VALUES (nextval('payment_id_payment_seq'), 1, 125, NOW());

INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 1, 1, 3, NOW(), NOW(), NOW(), 120);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 2, 3, NOW(), NOW(), NOW(), 340);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 1, 3, 3, NOW(), NOW(), NOW(), 110);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 2, 4, 3, NOW(), NOW(), NOW(), 420);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 5, 3, NOW(), NOW(), NOW(), 490);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 6, 1, NOW(), NOW(), NOW(), 150);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 1, 1, NOW(), NOW(), NOW(), 90);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 3, 2, NOW(), NOW(), NOW(), 130);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 1, 4, 2, NOW(), NOW(), NOW(), 175);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 2, 1, 3, NOW(), NOW(), NOW(), 200);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 2, 4, NOW(), NOW(), NOW(), 140);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 3, 3, 4, NOW(), NOW(), NOW(), 200);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 2, 1, 4, NOW(), NOW(), NOW(), 220);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 1, 5, 1, NOW(), NOW(), NOW(), 160);
INSERT INTO reservation VALUES (nextval('reservation_id_reservation_seq'), 1, 4, 5, NOW(), NOW(), NOW(), 120);

INSERT INTO room_status VALUES (nextval('room_status_id_room_status_seq'), 'Not empty', 'Room not empty');
INSERT INTO room_status VALUES (nextval('room_status_id_room_status_seq'), 'Empty', 'Room empty');
INSERT INTO room_status VALUES (nextval('room_status_id_room_status_seq'), 'Reserved', 'Room reserved');

INSERT INTO room VALUES (nextval('room_id_room_seq'), 1, 3, 'A triple room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 2, 4, 'Four-person room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 2, 4, 'Four-person room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 1, 5, 'Five-person room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 1, 2, 'Double room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 2, 2, 'Double room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 1, 3, 'A triple room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 3, 4, 'Four-person room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 2, 5, 'Five-person room');
INSERT INTO room VALUES (nextval('room_id_room_seq'), 1, 5, 'Five-person room');

INSERT INTO room_type VALUES (nextval('room_type_id_room_type_seq'), 'Basic', 1);
INSERT INTO room_type VALUES (nextval('room_type_id_room_type_seq'), 'Premium', 2);
INSERT INTO room_type VALUES (nextval('room_type_id_room_type_seq'), 'Luxury', 3);

INSERT INTO rate VALUES (nextval('rate_id_rate_seq'), 1, 2, 200);
INSERT INTO rate VALUES (nextval('rate_id_rate_seq'), 2, 2, 200);
INSERT INTO rate VALUES (nextval('rate_id_rate_seq'), 3, 3, 200);

INSERT INTO room_x_reservation VALUES (1, 1, 420);
INSERT INTO room_x_reservation VALUES (2, 2, 120);
INSERT INTO room_x_reservation VALUES (3, 2, 135);
INSERT INTO room_x_reservation VALUES (4, 1, 200);
INSERT INTO room_x_reservation VALUES (5, 2, 150);


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
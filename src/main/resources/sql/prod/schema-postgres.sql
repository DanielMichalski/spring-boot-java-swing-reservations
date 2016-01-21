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
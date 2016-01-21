
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

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
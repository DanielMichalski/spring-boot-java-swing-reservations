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
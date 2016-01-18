INSERT INTO Adres VALUES (1, 'Długa', 5, 34, 'Poznań', '44-300');
INSERT INTO Adres VALUES (2, 'Daleka', 54, 66, 'Gdynia', '49-321');
INSERT INTO Adres VALUES (3, 'Siwa', 31, 43, 'Wrocłas', '34-323');

INSERT INTO Klient VALUES (1, 1, 'Jan', 'Nowak', '9010100293', '500493003', 'janek21313@wp.pl');
INSERT INTO Klient VALUES (2, 2, 'Juliusz', 'Cezar', '8810120293', '504939203', 'kulek123121@wp.pl');
INSERT INTO Klient VALUES (3, 3, 'Marta', 'Kownacka', '9105030293', '511493003', 'marta3421@gmail.pl');
INSERT INTO Klient VALUES (4, 1, 'Jan', 'Nowosielski', '9205030293', '521493003', 'jannowosielski2344@onet.pl');
INSERT INTO Klient VALUES (5, 2, 'Marta', 'Korycka', '9205030293', '503493003', 'martakorycka2349@wp.pl');

INSERT INTO Status_rezerwacji VALUES (1, 'Nowa');
INSERT INTO Status_rezerwacji VALUES (2, 'Zakończona');
INSERT INTO Status_rezerwacji VALUES (3, 'Anulowana');

INSERT INTO PlatnoscMetoda VALUES (1, 'Karta debetowa');
INSERT INTO PlatnoscMetoda VALUES (2, 'Karta kredytowa');
INSERT INTO PlatnoscMetoda VALUES (3, 'Gotówka');

INSERT INTO Platnosc VALUES (1, 1, 100, NOW());
INSERT INTO Platnosc VALUES (2, 2, 220, NOW());
INSERT INTO Platnosc VALUES (3, 3, 260, NOW());
INSERT INTO Platnosc VALUES (4, 3, 150, NOW());
INSERT INTO Platnosc VALUES (5, 2, 240, NOW());
INSERT INTO Platnosc VALUES (6, 2, 130, NOW());
INSERT INTO Platnosc VALUES (7, 3, 355, NOW());
INSERT INTO Platnosc VALUES (8, 2, 435, NOW());
INSERT INTO Platnosc VALUES (9, 2, 755, NOW());
INSERT INTO Platnosc VALUES (10, 1, 125, NOW());

INSERT INTO Rezerwacja VALUES (1, 1, 1, 3, NOW(), NOW(), NOW(), 120);
INSERT INTO Rezerwacja VALUES (2, 3, 2, 3, NOW(), NOW(), NOW(), 340);
INSERT INTO Rezerwacja VALUES (3, 1, 3, 3, NOW(), NOW(), NOW(), 110);
INSERT INTO Rezerwacja VALUES (4, 2, 4, 3, NOW(), NOW(), NOW(), 420);
INSERT INTO Rezerwacja VALUES (5, 3, 5, 3, NOW(), NOW(), NOW(), 490);
INSERT INTO Rezerwacja VALUES (6, 3, 6, 1, NOW(), NOW(), NOW(), 150);
INSERT INTO Rezerwacja VALUES (7, 3, 1, 1, NOW(), NOW(), NOW(), 90);
INSERT INTO Rezerwacja VALUES (8, 3, 3, 2, NOW(), NOW(), NOW(), 130);
INSERT INTO Rezerwacja VALUES (9, 1, 4, 2, NOW(), NOW(), NOW(), 175);
INSERT INTO Rezerwacja VALUES (10, 2,1, 3, NOW(), NOW(), NOW(), 200);
INSERT INTO Rezerwacja VALUES (11, 3, 2, 4, NOW(), NOW(), NOW(), 140);
INSERT INTO Rezerwacja VALUES (12, 3, 3, 4, NOW(), NOW(), NOW(), 200);
INSERT INTO Rezerwacja VALUES (13, 2, 1, 4, NOW(), NOW(), NOW(), 220);
INSERT INTO Rezerwacja VALUES (14, 1, 5, 1, NOW(), NOW(), NOW(), 160);
INSERT INTO Rezerwacja VALUES (15, 1, 4, 5, NOW(), NOW(), NOW(), 120);

INSERT INTO PokojStatus VALUES (1, 'Zajęty', 'Pokój zajęty');
INSERT INTO PokojStatus VALUES (2, 'Wolny', 'Pokój wolny');
INSERT INTO PokojStatus VALUES (3, 'Zarezerwowany', 'Pokój zarezerwowany');

INSERT INTO Pokoj VALUES (1, 1, 3, 'Pokój trzyosobowy');
INSERT INTO Pokoj VALUES (2, 2, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (3, 2, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (4, 1, 5, 'Pokój pięcioosobowy');
INSERT INTO Pokoj VALUES (5, 1, 2, 'Pokój dwuosobowy');
INSERT INTO Pokoj VALUES (6, 2, 2, 'Pokój dwuosobowy');
INSERT INTO Pokoj VALUES (7, 1, 3, 'Pokój trzyosobowy');
INSERT INTO Pokoj VALUES (8, 3, 4, 'Pokój czterosobowy');
INSERT INTO Pokoj VALUES (9, 2, 5, 'Pokój pięcioosobowy');
INSERT INTO Pokoj VALUES (10, 1, 5, 'Pokój pięciioosobowy');

INSERT INTO PokojTyp VALUES (1, 'Zwykły', 1);
INSERT INTO PokojTyp VALUES (2, 'Premium', 2);
INSERT INTO PokojTyp VALUES (3, 'Nadzwyczajny', 3);

INSERT INTO Stawka VALUES (1, 1, 2, 200);
INSERT INTO Stawka VALUES (2, 2, 2, 200);
INSERT INTO Stawka VALUES (3, 3, 3, 200);

INSERT INTO Pokoj_x_Rezerwacja VALUES (1, 1, 420);
INSERT INTO Pokoj_x_Rezerwacja VALUES (1, 2, 120);
INSERT INTO Pokoj_x_Rezerwacja VALUES (2, 2, 135);
INSERT INTO Pokoj_x_Rezerwacja VALUES (2, 1, 200);
INSERT INTO Pokoj_x_Rezerwacja VALUES (3, 2, 150);
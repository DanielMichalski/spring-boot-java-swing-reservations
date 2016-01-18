CREATE VIEW v_podstawoweInformacjeKlient AS
  SELECT
    k.Imie,
    k.Nazwisko,
    adres.miasto
  FROM klient k
    LEFT JOIN adres ON k.IDAdres = adres.IDAdres
  ORDER BY k.Nazwisko ASC;


CREATE VIEW v_liczbaDostepnychPokoiTyp AS
  SELECT
    ps.opisstatusu,
    COUNT(pt.opis)
  FROM pokoj p
    LEFT JOIN stawka s ON s.idpokoj = p.idpokoj
    LEFT JOIN pokojtyp pt ON p.IDPokoj = s.IDPokojTyp
    LEFT JOIN pokojstatus ps ON p.IDPokojStatus = ps.IDPokojStatus
  WHERE ps.IDPokojStatus = 2
  GROUP BY (pt.Opis);


CREATE VIEW v_emailKlientLiczbaRezerwacji as
SELECT
  k.email,
  COUNT(r.IDRezerwacja) "ilosc rezerwacji"
FROM klient k
  LEFT JOIN rezerwacja r ON k.idklient = r.IDKlient
GROUP BY (k.email)
ORDER BY ("ilosc rezerwacji") DESC;

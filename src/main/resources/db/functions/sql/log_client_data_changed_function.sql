CREATE OR REPLACE FUNCTION log_address_changed()
  RETURNS TRIGGER AS
$body$
BEGIN
  INSERT INTO address_history (address_id, street, house_number, flat_number, city, postal_code, change_date)
  VALUES (OLD.address_id, OLD.street, OLD.house_number, OLD.flat_number, OLD.city, postal_code, now());
  RETURN NEW;
END;
$body$ LANGUAGE plpgsql;

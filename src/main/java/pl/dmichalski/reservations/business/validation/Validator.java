package pl.dmichalski.reservations.business.validation;

import java.util.Optional;

public interface Validator<K> {

    Optional<ValidationError> validate(K k);

}

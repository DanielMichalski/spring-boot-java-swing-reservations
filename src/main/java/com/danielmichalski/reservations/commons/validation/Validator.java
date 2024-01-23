package com.danielmichalski.reservations.commons.validation;

import java.util.Optional;

public interface Validator<K> {

    Optional<ValidationError> validate(K k);

}

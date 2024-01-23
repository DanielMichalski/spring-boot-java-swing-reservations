package com.danielmichalski.reservations.domain.address.validation;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.commons.validation.ValidationSupport;
import com.danielmichalski.reservations.commons.validation.Validator;
import com.danielmichalski.reservations.domain.address.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class AddressValidator extends ValidationSupport implements Validator<AddressEntity> {

    @Override
    public Optional<ValidationError> validate(AddressEntity address) {
        if (isNullOrEmptyString(address.getStreet())
                || isNullOrEmptyString(address.getHouseNumber())
                || isNullOrEmptyString(address.getFlatNumber())
                || isNullOrEmptyString(address.getCity())
                || isNullOrEmptyString(address.getPostalCode())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package com.danielmichalski.reservations.business.validation.address;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class AddressValidator extends ValidationSupport implements Validator<AddressEntity> {

    @Override
    public Optional<ValidationError> validate(AddressEntity address) {
        if (isNullOrEmptyString(address.getStreet()) ||
                isNullOrEmptyString(address.getHouseNumber()) ||
                isNullOrEmptyString(address.getFlatNumber()) ||
                isNullOrEmptyString(address.getCity()) ||
                isNullOrEmptyString(address.getPostalCode())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

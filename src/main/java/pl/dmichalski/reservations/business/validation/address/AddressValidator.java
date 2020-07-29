package pl.dmichalski.reservations.business.validation.address;

import java.util.Optional;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.address.AddressEntity;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.ValidationSupport;
import pl.dmichalski.reservations.business.validation.Validator;

import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

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

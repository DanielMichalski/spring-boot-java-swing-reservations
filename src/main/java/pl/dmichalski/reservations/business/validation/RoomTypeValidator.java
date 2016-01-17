package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.util.ConstMessages;

import java.util.Optional;

@Component
public class RoomTypeValidator extends ValidationSupport implements Validator<RoomType> {

    @Override
    public Optional<ValidationError> validate(RoomType roomType) {
        if (isNullOrEmptyString(roomType.getDescription()) ||
                !isValueGreaterThanZero(roomType.getMultiplier())) {
            return Optional.of(new ValidationError(ConstMessages.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomType;

import java.util.Optional;

import static pl.dmichalski.reservations.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomTypeValidator extends ValidationSupport implements Validator<RoomType> {

    @Override
    public Optional<ValidationError> validate(RoomType roomType) {
        if (isNullOrEmptyString(roomType.getDescription()) ||
                !isValueGreaterThanZero(roomType.getMultiplier())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

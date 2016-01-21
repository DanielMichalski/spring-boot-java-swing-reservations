package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import java.util.Optional;

@Component
public class RoomValidator extends ValidationSupport implements Validator<Room> {

    @Override
    public Optional<ValidationError> validate(Room room) {
        if (isNullValue(room.getRoomStatus()) ||
                !isValueGreaterThanZero(room.getNumberOfPeople()) ||
                isNullOrEmptyString(room.getDescription())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomXReservation;
import pl.dmichalski.reservations.business.util.ConstMessages;

import java.util.Optional;

@Component
public class RoomXReservationValidator extends ValidationSupport implements Validator<RoomXReservation> {

    @Override
    public Optional<ValidationError> validate(RoomXReservation roomXReservation) {
        if (isNullValue(roomXReservation.getReservation()) ||
                isNullValue(roomXReservation.getReservation()) ||
                !isValueGreaterThanZero(roomXReservation.getRoomPrice())) {
            return Optional.of(new ValidationError(ConstMessages.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

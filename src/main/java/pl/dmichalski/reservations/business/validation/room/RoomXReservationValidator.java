package pl.dmichalski.reservations.business.validation.room;

import java.util.Optional;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.ValidationSupport;
import pl.dmichalski.reservations.business.validation.Validator;

import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomXReservationValidator extends ValidationSupport implements Validator<RoomXReservationEntity> {

    @Override
    public Optional<ValidationError> validate(RoomXReservationEntity roomXReservation) {
        if (isNullValue(roomXReservation.getReservation()) ||
                isNullValue(roomXReservation.getReservation()) ||
                isValueNotGreaterThanZero(roomXReservation.getRoomPrice())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package com.danielmichalski.reservations.domain.room.validation;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.commons.validation.ValidationSupport;
import com.danielmichalski.reservations.commons.validation.Validator;
import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomXReservationValidator extends ValidationSupport implements Validator<RoomXReservationEntity> {

    @Override
    public Optional<ValidationError> validate(RoomXReservationEntity roomXReservation) {
        if (isNullValue(roomXReservation.getReservation())
                || isNullValue(roomXReservation.getReservation())
                || isValueNotGreaterThanZero(roomXReservation.getRoomPrice())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

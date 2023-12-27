package com.danielmichalski.reservations.validation.room;

import com.danielmichalski.reservations.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomValidator extends ValidationSupport implements Validator<RoomEntity> {

    @Override
    public Optional<ValidationError> validate(RoomEntity room) {
        if (isNullValue(room.getRoomStatus())
                || isValueNotGreaterThanZero(Long.valueOf(room.getNumberOfPeople()))
                || isNullOrEmptyString(room.getDescription())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package com.danielmichalski.reservations.business.validation.room;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomValidator extends ValidationSupport implements Validator<RoomEntity> {

    @Override
    public Optional<ValidationError> validate(RoomEntity room) {
        if (isNullValue(room.getRoomStatus()) ||
                isValueNotGreaterThanZero(room.getNumberOfPeople()) ||
                isNullOrEmptyString(room.getDescription())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

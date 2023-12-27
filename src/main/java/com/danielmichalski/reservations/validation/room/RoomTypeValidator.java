package com.danielmichalski.reservations.validation.room;

import com.danielmichalski.reservations.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomTypeValidator extends ValidationSupport implements Validator<RoomTypeEntity> {

    @Override
    public Optional<ValidationError> validate(RoomTypeEntity roomType) {
        if (isNullOrEmptyString(roomType.getDescription())
                || isValueNotGreaterThanZero(Long.valueOf(roomType.getMultiplier()))) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

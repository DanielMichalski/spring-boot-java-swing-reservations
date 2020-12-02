package com.danielmichalski.reservations.business.validation.room;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomTypeValidator extends ValidationSupport implements Validator<RoomTypeEntity> {

    @Override
    public Optional<ValidationError> validate(RoomTypeEntity roomType) {
        if (isNullOrEmptyString(roomType.getDescription()) ||
                isValueNotGreaterThanZero(roomType.getMultiplier())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

package com.danielmichalski.reservations.business.validation.room;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomStatusValidator extends ValidationSupport implements Validator<RoomStatusEntity> {

    @Override
    public Optional<ValidationError> validate(RoomStatusEntity roomStatus) {
        if (isNullOrEmptyString(roomStatus.getStatus()) ||
                isNullOrEmptyString(roomStatus.getStatusDescription())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

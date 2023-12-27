package com.danielmichalski.reservations.validation.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationStatusEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class ReservationStatusValidator extends ValidationSupport implements Validator<ReservationStatusEntity> {

    @Override
    public Optional<ValidationError> validate(ReservationStatusEntity reservationStatus) {
        if (isNullOrEmptyString(reservationStatus.getStatus())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

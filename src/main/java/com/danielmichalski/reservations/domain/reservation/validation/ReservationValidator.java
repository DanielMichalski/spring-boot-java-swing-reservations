package com.danielmichalski.reservations.domain.reservation.validation;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.commons.validation.ValidationSupport;
import com.danielmichalski.reservations.commons.validation.Validator;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE;
import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;
import static java.util.Optional.empty;

@Component
public class ReservationValidator extends ValidationSupport implements Validator<ReservationEntity> {

    @Override
    public Optional<ValidationError> validate(ReservationEntity reservation) {
        if (isNullValue(reservation.getReservationStatus())
                || isNullValue(reservation.getPayment())
                || isNullValue(reservation.getClient())
                || isNullValue(reservation.getFromDate())
                || isNullValue(reservation.getToDate())
                || isNullValue(reservation.getReservationDate())
                || isValueNotGreaterThanZero(reservation.getAmount())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (reservation.getFromDate().after(reservation.getToDate())) {
            return Optional.of(new ValidationError(DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE));
        }
        return empty();
    }

}

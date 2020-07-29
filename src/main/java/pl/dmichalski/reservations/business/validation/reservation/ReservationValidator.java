package pl.dmichalski.reservations.business.validation.reservation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.ValidationSupport;
import pl.dmichalski.reservations.business.validation.Validator;

import static java.util.Optional.empty;
import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE;
import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class ReservationValidator extends ValidationSupport implements Validator<ReservationEntity> {

    @Override
    public Optional<ValidationError> validate(ReservationEntity reservation) {
        if (isNullValue(reservation.getReservationStatus()) ||
                isNullValue(reservation.getPayment()) ||
                isNullValue(reservation.getClient()) ||
                isNullValue(reservation.getFromDate()) ||
                isNullValue(reservation.getToDate()) ||
                isNullValue(reservation.getReservationDate()) ||
                !isValueGreaterThanZero(reservation.getAmount())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (reservation.getFromDate().after(reservation.getToDate())) {
            return Optional.of(new ValidationError(DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE));
        }
        return empty();
    }

}

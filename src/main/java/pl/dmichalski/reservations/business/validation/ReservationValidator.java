package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import java.util.Optional;

@Component
public class ReservationValidator extends ValidationSupport implements Validator<Reservation> {

    @Override
    public Optional<ValidationError> validate(Reservation reservation) {
        if (isNullValue(reservation.getReservationStatus()) ||
                isNullValue(reservation.getPayment()) ||
                isNullValue(reservation.getClient()) ||
                isNullValue(reservation.getDateFrom()) ||
                isNullValue(reservation.getDateTo()) ||
                isNullValue(reservation.getReservationDate()) ||
                !isValueGreaterThanZero(reservation.getAmount())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (reservation.getDateFrom().after(reservation.getDateTo())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE));
        }
        return Optional.empty();
    }

}

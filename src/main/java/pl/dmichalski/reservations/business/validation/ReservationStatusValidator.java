package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.util.ConstMessages;

import java.util.Optional;

@Component
public class ReservationStatusValidator extends ValidationSupport implements Validator<ReservationStatus> {

    @Override
    public Optional<ValidationError> validate(ReservationStatus reservationStatus) {
        if (isNullOrEmptyString(reservationStatus.getReservationStatus())) {
            return Optional.of(new ValidationError(ConstMessages.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

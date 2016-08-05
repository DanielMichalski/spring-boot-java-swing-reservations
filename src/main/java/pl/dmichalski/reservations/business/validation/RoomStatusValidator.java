package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomStatus;

import java.util.Optional;

import static pl.dmichalski.reservations.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RoomStatusValidator extends ValidationSupport implements Validator<RoomStatus> {

    @Override
    public Optional<ValidationError> validate(RoomStatus roomStatus) {
        if (isNullOrEmptyString(roomStatus.getRoomStatus()) ||
                isNullOrEmptyString(roomStatus.getDescription())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

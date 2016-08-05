package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Rate;

import java.util.Optional;

import static pl.dmichalski.reservations.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RateValidator extends ValidationSupport implements Validator<Rate> {

    @Override
    public Optional<ValidationError> validate(Rate rate) {
        if (isNullValue(rate.getRoom()) ||
                isNullValue(rate.getRoomType()) ||
                !isValueGreaterThanZero(rate.getBasicRate())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

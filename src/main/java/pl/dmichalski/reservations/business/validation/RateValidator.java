package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import java.util.Optional;

@Component
public class RateValidator extends ValidationSupport implements Validator<Rate> {

    @Override
    public Optional<ValidationError> validate(Rate rate) {
        if (isNullValue(rate.getRoom()) ||
                isNullValue(rate.getRoomType()) ||
                !isValueGreaterThanZero(rate.getBasicRate())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

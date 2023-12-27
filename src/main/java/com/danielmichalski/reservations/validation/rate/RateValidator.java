package com.danielmichalski.reservations.validation.rate;

import com.danielmichalski.reservations.domain.entity.rate.RateEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RateValidator extends ValidationSupport implements Validator<RateEntity> {

    @Override
    public Optional<ValidationError> validate(RateEntity rate) {
        if (isNullValue(rate.getRoom())
                || isNullValue(rate.getRoomType())
                || isValueNotGreaterThanZero(rate.getDefaultRate())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

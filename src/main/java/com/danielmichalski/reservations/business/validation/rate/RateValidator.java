package com.danielmichalski.reservations.business.validation.rate;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.rate.RateEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class RateValidator extends ValidationSupport implements Validator<RateEntity> {

    @Override
    public Optional<ValidationError> validate(RateEntity rate) {
        if (isNullValue(rate.getRoom()) ||
                isNullValue(rate.getRoomType()) ||
                isValueNotGreaterThanZero(rate.getDefaultRate())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

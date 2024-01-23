package com.danielmichalski.reservations.domain.payment.validation;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.commons.validation.ValidationSupport;
import com.danielmichalski.reservations.commons.validation.Validator;
import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class PaymentMethodValidator extends ValidationSupport implements Validator<PaymentMethodEntity> {

    @Override
    public Optional<ValidationError> validate(PaymentMethodEntity paymentMethod) {
        if (isNullOrEmptyString(paymentMethod.getName())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

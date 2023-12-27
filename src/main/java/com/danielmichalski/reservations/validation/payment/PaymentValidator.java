package com.danielmichalski.reservations.validation.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.validation.ValidationError;
import com.danielmichalski.reservations.validation.ValidationSupport;
import com.danielmichalski.reservations.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.danielmichalski.reservations.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;
import static java.util.Optional.empty;

@Component
public class PaymentValidator extends ValidationSupport implements Validator<PaymentEntity> {

    @Override
    public Optional<ValidationError> validate(PaymentEntity payment) {
        if (isNullValue(payment.getPaymentMethod())
                || isValueNotGreaterThanZero(payment.getValue())
                || isNullValue(payment.getDateOfPayment())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return empty();
    }

}

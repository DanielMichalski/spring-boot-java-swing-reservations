package com.danielmichalski.reservations.business.validation.payment;

import java.util.Optional;

import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.ValidationSupport;
import com.danielmichalski.reservations.business.validation.Validator;

import static java.util.Optional.empty;
import static com.danielmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

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

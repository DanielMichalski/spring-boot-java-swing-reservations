package pl.dmichalski.reservations.business.validation.payment;

import java.util.Optional;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.ValidationSupport;
import pl.dmichalski.reservations.business.validation.Validator;

import static java.util.Optional.empty;
import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class PaymentValidator extends ValidationSupport implements Validator<PaymentEntity> {

    @Override
    public Optional<ValidationError> validate(PaymentEntity payment) {
        if (isNullValue(payment.getPaymentMethod())
                || !isValueGreaterThanZero(payment.getValue())
                || isNullValue(payment.getDateOfPayment())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return empty();
    }

}

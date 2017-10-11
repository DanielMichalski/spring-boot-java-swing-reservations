package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Payment;

import java.util.Optional;

import static java.util.Optional.empty;
import static pl.dmichalski.reservations.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class PaymentValidator extends ValidationSupport implements Validator<Payment> {

    @Override
    public Optional<ValidationError> validate(Payment payment) {
        if (isNullValue(payment.getPaymentMethod())
                || !isValueGreaterThanZero(payment.getValue())
                || isNullValue(payment.getDateOfPayments())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return empty();
    }

}

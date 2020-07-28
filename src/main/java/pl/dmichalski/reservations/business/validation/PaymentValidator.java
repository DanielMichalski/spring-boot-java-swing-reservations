package pl.dmichalski.reservations.business.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentEntity;

import static java.util.Optional.empty;
import static pl.dmichalski.reservations.business.util.constant.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class PaymentValidator extends ValidationSupport implements Validator<PaymentEntity> {

    @Override
    public Optional<ValidationError> validate(PaymentEntity payment) {
        if (isNullValue(payment.getPaymentMethod())
                || !isValueGreaterThanZero(payment.getValue())
                || isNullValue(payment.getDateOfPayments())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return empty();
    }

}

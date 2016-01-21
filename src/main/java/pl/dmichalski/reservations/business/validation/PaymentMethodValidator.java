package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import java.util.Optional;

@Component
public class PaymentMethodValidator extends ValidationSupport implements Validator<PaymentMethod> {

    @Override
    public Optional<ValidationError> validate(PaymentMethod paymentMethod) {
        if (isNullOrEmptyString(paymentMethod.getName())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

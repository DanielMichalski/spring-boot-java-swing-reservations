package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.PaymentMethod;

import java.util.Optional;

import static pl.dmichalski.reservations.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

@Component
public class PaymentMethodValidator extends ValidationSupport implements Validator<PaymentMethod> {

    @Override
    public Optional<ValidationError> validate(PaymentMethod paymentMethod) {
        if (isNullOrEmptyString(paymentMethod.getName())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}

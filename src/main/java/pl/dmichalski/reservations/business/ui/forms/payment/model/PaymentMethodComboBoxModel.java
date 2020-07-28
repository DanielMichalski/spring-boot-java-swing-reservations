package pl.dmichalski.reservations.business.ui.forms.payment.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultComboBoxModel;

@Component
public class PaymentMethodComboBoxModel extends DefaultComboBoxModel<PaymentMethodEntity> {
}

package pl.dmichalski.reservations.business.ui.forms.payment.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Payment;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.DateFormatter;

@Component
public class PaymentTableModel extends DefaultTableModel<Payment> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Payment payment = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return payment.getPaymentMethod();
            case 1:
                return payment.getValue();
            case 2:
                return DateFormatter.formatDate(payment.getDateOfPayments());
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAYMENT_METHOD,
                ConstMessagesEN.Labels.VALUE,
                ConstMessagesEN.Labels.DATE_OF_PAYMENT};
    }
}

package pl.dmichalski.reservations.business.ui.forms.payment.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.date.DateFormatter;

@Component
public class PaymentTableModel extends DefaultTableModel<PaymentEntity> {

    private static final int PAYMENT_METHOD_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private static final int DATE_OF_PAYMENT_INDEX = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentEntity payment = entities.get(rowIndex);
        switch (columnIndex) {
            case PAYMENT_METHOD_INDEX:
                return payment.getPaymentMethod();
            case VALUE_INDEX:
                return payment.getValue();
            case DATE_OF_PAYMENT_INDEX:
                return DateFormatter.formatDate(payment.getDateOfPayment());
            default:
                return Strings.EMPTY;
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

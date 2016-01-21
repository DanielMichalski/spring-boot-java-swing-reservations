package pl.dmichalski.reservations.business.ui.reports.payments.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.domain.PaymentMethodCount;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class PaymentReportModel extends DefaultTableModel<PaymentMethodCount> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAYMENT_METHOD,
                ConstMessagesEN.Labels.PAYMENT_COUNT
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethodCount paymentMethodCount = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return paymentMethodCount.getName();
            case 1:
                return paymentMethodCount.getCount();
            default:
                return "";
        }
    }

}

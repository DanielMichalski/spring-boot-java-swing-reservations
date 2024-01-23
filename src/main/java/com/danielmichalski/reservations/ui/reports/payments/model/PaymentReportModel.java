package com.danielmichalski.reservations.ui.reports.payments.model;

import com.danielmichalski.reservations.domain.payment.dto.PaymentMethodCountDto;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class PaymentReportModel extends DefaultTableModel<PaymentMethodCountDto> {

    private static final int PAYMENT_METHOD_INDEX = 0;
    private static final int PAYMENT_COUNT_INDEX = 1;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethodCountDto paymentMethodCount = entities.get(rowIndex);

        switch (columnIndex) {
            case PAYMENT_METHOD_INDEX:
                return paymentMethodCount.name();
            case PAYMENT_COUNT_INDEX:
                return paymentMethodCount.count();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAYMENT_METHOD,
                ConstMessagesEN.Labels.PAYMENT_COUNT
        };
    }

}

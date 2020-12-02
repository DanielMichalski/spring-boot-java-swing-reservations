package com.danielmichalski.reservations.business.ui.reports.payments.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.dto.payment.PaymentMethodCountDto;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class PaymentReportModel extends DefaultTableModel<PaymentMethodCountDto> {

    private static final int PAYMENT_METHOD_INDEX = 0;
    private static final int PAYMENT_COUNT_INDEX = 1;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethodCountDto paymentMethodCount = entities.get(rowIndex);

        switch (columnIndex) {
            case PAYMENT_METHOD_INDEX:
                return paymentMethodCount.getName();
            case PAYMENT_COUNT_INDEX:
                return paymentMethodCount.getCount();
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

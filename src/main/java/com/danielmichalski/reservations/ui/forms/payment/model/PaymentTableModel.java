package com.danielmichalski.reservations.ui.forms.payment.model;

import com.danielmichalski.reservations.commons.date.DateFormatterService;
import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentTableModel extends DefaultTableModel<PaymentEntity> {

    private static final int PAYMENT_METHOD_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private static final int DATE_OF_PAYMENT_INDEX = 2;

    private final DateFormatterService dateFormatterService;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentEntity payment = entities.get(rowIndex);
        switch (columnIndex) {
            case PAYMENT_METHOD_INDEX:
                return payment.getPaymentMethod();
            case VALUE_INDEX:
                return payment.getValue();
            case DATE_OF_PAYMENT_INDEX:
                return dateFormatterService.formatDate(payment.getDateOfPayment());
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

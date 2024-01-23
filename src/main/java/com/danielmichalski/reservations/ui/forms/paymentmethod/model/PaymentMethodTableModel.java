package com.danielmichalski.reservations.ui.forms.paymentmethod.model;

import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodTableModel extends DefaultTableModel<PaymentMethodEntity> {

    private static final int NAME_INDEX = 0;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethodEntity paymentMethod = entities.get(rowIndex);
        if (columnIndex == NAME_INDEX) {
            return paymentMethod.getName();
        }
        return Strings.EMPTY;
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.PAYMENT_METHOD};
    }
}

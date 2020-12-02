package com.danielmichalski.reservations.business.ui.forms.client.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class ClientTableModel extends DefaultTableModel<ClientEntity> {

    private static final int NAME_INDEX = 0;
    private static final int SURNAME_INDEX = 1;
    private static final int PESEL_INDEX = 2;
    private static final int PHONE_NUMBER_INDEX = 3;
    private static final int EMAIL_INDEX = 4;
    private static final int ADDRESS_INDEX = 5;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.NAME,
                ConstMessagesEN.Labels.SURNAME,
                ConstMessagesEN.Labels.PESEL,
                ConstMessagesEN.Labels.PHONE_NUMBER,
                ConstMessagesEN.Labels.EMAIL,
                ConstMessagesEN.Labels.ADDRESS};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClientEntity client = entities.get(rowIndex);

        switch (columnIndex) {
            case NAME_INDEX:
                return client.getName();
            case SURNAME_INDEX:
                return client.getSurname();
            case PESEL_INDEX:
                return client.getPesel();
            case PHONE_NUMBER_INDEX:
                return client.getPhoneNumber();
            case EMAIL_INDEX:
                return client.getEmail();
            case ADDRESS_INDEX:
                return client.getAddress();
            default:
                return Strings.EMPTY;
        }
    }
}

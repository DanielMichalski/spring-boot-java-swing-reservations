package com.danielmichalski.reservations.business.ui.forms.address.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class AddressTableModel extends DefaultTableModel<AddressEntity> {

    private static final int STREET_INDEX = 0;
    private static final int HOUSE_NUMBER_INDEX = 1;
    private static final int FLAT_NUMBER_INDEX = 2;
    private static final int CITY_INDEX = 3;
    private static final int POSTAL_CODE_INDEX = 4;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.STREET,
                ConstMessagesEN.Labels.HOUSE_NUMBER,
                ConstMessagesEN.Labels.FLAT_NUMBER,
                ConstMessagesEN.Labels.CITY,
                ConstMessagesEN.Labels.POSTAL_CODE};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AddressEntity address = entities.get(rowIndex);

        switch (columnIndex) {
            case STREET_INDEX:
                return address.getStreet();
            case HOUSE_NUMBER_INDEX:
                return address.getHouseNumber();
            case FLAT_NUMBER_INDEX:
                return address.getFlatNumber();
            case CITY_INDEX:
                return address.getCity();
            case POSTAL_CODE_INDEX:
                return address.getPostalCode();
            default:
                return Strings.EMPTY;
        }
    }

}

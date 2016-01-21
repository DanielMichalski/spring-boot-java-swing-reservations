package pl.dmichalski.reservations.business.ui.forms.address.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Address;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class AddressTableModel extends DefaultTableModel<Address> {

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
        Address address = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return address.getStreet();
            case 1:
                return address.getHouseNumber();
            case 2:
                return address.getFlatNumber();
            case 3:
                return address.getCity();
            case 4:
                return address.getPostCode();
            default:
                return "";
        }
    }

}

package pl.dmichalski.reservations.business.ui.address.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Address;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class AddressTableModel extends DefaultTableModel<Address> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.STREET,
                ConstMessages.Labels.HOUSE_NUMBER,
                ConstMessages.Labels.FLAT_NUMBER,
                ConstMessages.Labels.CITY,
                ConstMessages.Labels.POSTAL_CODE};
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

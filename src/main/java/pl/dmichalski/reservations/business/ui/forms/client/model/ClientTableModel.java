package pl.dmichalski.reservations.business.ui.forms.client.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class ClientTableModel extends DefaultTableModel<Client> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.NAME,
                ConstMessages.Labels.SURNAME,
                ConstMessages.Labels.PESEL,
                ConstMessages.Labels.PHONE_NUMBER,
                ConstMessages.Labels.EMAIL,
                ConstMessages.Labels.ADDRESS};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getSurname();
            case 2:
                return client.getPesel();
            case 3:
                return client.getPhoneNumber();
            case 4:
                return client.getEmail();
            case 5:
                return client.getAddress();
            default:
                return "";
        }
    }
}

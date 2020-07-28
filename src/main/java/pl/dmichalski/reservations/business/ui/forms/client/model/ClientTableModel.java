package pl.dmichalski.reservations.business.ui.forms.client.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.client.ClientEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class ClientTableModel extends DefaultTableModel<ClientEntity> {

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

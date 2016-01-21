package pl.dmichalski.reservations.business.ui.reports.client_reservations.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.domain.ClientReservationCount;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class ClientReservationsReportModel extends DefaultTableModel<ClientReservationCount> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.NAME,
                ConstMessagesEN.Labels.EMAIL,
                ConstMessagesEN.Labels.NUMBER_OF_RESERVATIONS
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClientReservationCount clientReservationCount = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return clientReservationCount.getName();
            case 1:
                return clientReservationCount.getEmail();
            case 2:
                return clientReservationCount.getCount();
            default:
                return "";
        }
    }

}

package pl.dmichalski.reservations.business.ui.reports.client_reservations.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.dto.client.ClientReservationCountDto;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class ClientReservationsReportModel extends DefaultTableModel<ClientReservationCountDto> {

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
        ClientReservationCountDto clientReservationCountDto = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return clientReservationCountDto.getName();
            case 1:
                return clientReservationCountDto.getEmail();
            case 2:
                return clientReservationCountDto.getCount();
            default:
                return "";
        }
    }

}

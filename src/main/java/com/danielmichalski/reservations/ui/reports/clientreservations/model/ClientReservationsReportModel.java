package com.danielmichalski.reservations.ui.reports.clientreservations.model;

import com.danielmichalski.reservations.domain.client.dto.ClientReservationCountDto;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class ClientReservationsReportModel extends DefaultTableModel<ClientReservationCountDto> {

    private static final int NAME_INDEX = 0;
    private static final int EMAIL_INDEX = 1;
    private static final int NUMBER_OF_RESERVATIONS_INDEX = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClientReservationCountDto clientReservationCountDto = entities.get(rowIndex);

        switch (columnIndex) {
            case NAME_INDEX:
                return clientReservationCountDto.name();
            case EMAIL_INDEX:
                return clientReservationCountDto.email();
            case NUMBER_OF_RESERVATIONS_INDEX:
                return clientReservationCountDto.count();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.NAME,
                ConstMessagesEN.Labels.EMAIL,
                ConstMessagesEN.Labels.NUMBER_OF_RESERVATIONS
        };
    }
}

package com.danielmichalski.reservations.business.ui.reports.clientreservations.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.dto.client.ClientReservationCountDto;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

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
                return clientReservationCountDto.getName();
            case EMAIL_INDEX:
                return clientReservationCountDto.getEmail();
            case NUMBER_OF_RESERVATIONS_INDEX:
                return clientReservationCountDto.getCount();
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

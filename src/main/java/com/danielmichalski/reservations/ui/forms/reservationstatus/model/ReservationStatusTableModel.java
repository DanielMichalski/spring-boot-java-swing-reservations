package com.danielmichalski.reservations.ui.forms.reservationstatus.model;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class ReservationStatusTableModel extends DefaultTableModel<ReservationStatusEntity> {

    private static final int RESERVATION_STATUS_INDEX = 0;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationStatusEntity reservationStatus = entities.get(rowIndex);
        if (columnIndex == RESERVATION_STATUS_INDEX) {
            return reservationStatus.getStatus();
        }
        return Strings.EMPTY;
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.RESERVATION_STATUS};
    }
}

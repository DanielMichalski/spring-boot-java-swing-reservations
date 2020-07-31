package pl.dmichalski.reservations.business.ui.forms.reservationstatus.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

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

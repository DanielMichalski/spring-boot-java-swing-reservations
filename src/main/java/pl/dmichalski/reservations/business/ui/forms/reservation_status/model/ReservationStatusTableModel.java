package pl.dmichalski.reservations.business.ui.forms.reservation_status.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class ReservationStatusTableModel extends DefaultTableModel<ReservationStatusEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationStatusEntity reservationStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservationStatus.getStatus();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.RESERVATION_STATUS};
    }
}

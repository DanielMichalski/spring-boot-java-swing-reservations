package pl.dmichalski.reservations.business.ui.forms.reservation_status.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class ReservationStatusTableModel extends DefaultTableModel<ReservationStatus> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationStatus reservationStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservationStatus.getReservationStatus();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.RESERVATION_STATUS};
    }
}

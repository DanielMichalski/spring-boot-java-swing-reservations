package pl.dmichalski.reservations.business.ui.forms.reservation.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.date.DateFormatter;

@Component
public class ReservationTableModel extends DefaultTableModel<ReservationEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationEntity reservation = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservation.getReservationStatus();
            case 1:
                return reservation.getPayment();
            case 2:
                return reservation.getClient();
            case 3:
                return DateFormatter.formatDate(reservation.getFromDate());
            case 4:
                return DateFormatter.formatDate(reservation.getToDate());
            case 5:
                return DateFormatter.formatDate(reservation.getReservationDate());
            case 6:
                return reservation.getAmount();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.RESERVATION_STATUS,
                ConstMessagesEN.Labels.PAYMENT,
                ConstMessagesEN.Labels.CLIENT,
                ConstMessagesEN.Labels.FROM_DATE,
                ConstMessagesEN.Labels.TO_DATE,
                ConstMessagesEN.Labels.RESERVATION_DATE,
                ConstMessagesEN.Labels.AMOUNT};
    }
}

package pl.dmichalski.reservations.business.ui.forms.reservation.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.DateFormatter;

@Component
public class ReservationTableModel extends DefaultTableModel<Reservation> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservation reservation = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservation.getReservationStatus();
            case 1:
                return reservation.getPayment();
            case 2:
                return reservation.getClient();
            case 3:
                return DateFormatter.formatDate(reservation.getDateFrom());
            case 4:
                return DateFormatter.formatDate(reservation.getDateTo());
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

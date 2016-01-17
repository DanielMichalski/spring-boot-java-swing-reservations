package pl.dmichalski.reservations.business.ui.reservation.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;
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
                ConstMessages.Labels.RESERVATION_STATUS,
                ConstMessages.Labels.PAYMENT,
                ConstMessages.Labels.CLIENT,
                ConstMessages.Labels.FROM_DATE,
                ConstMessages.Labels.TO_DATE,
                ConstMessages.Labels.RESERVATION_DATE,
                ConstMessages.Labels.AMOUNT};
    }
}

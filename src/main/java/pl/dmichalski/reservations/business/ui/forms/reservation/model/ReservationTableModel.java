package pl.dmichalski.reservations.business.ui.forms.reservation.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.date.DateFormatter;

@Component
public class ReservationTableModel extends DefaultTableModel<ReservationEntity> {

    private static final int RESERVATION_STATUS_INDEX = 0;
    private static final int PAYMENT_INDEX = 1;
    private static final int CLIENT_INDEX = 2;
    private static final int FROM_DATE_INDEX = 3;
    private static final int TO_DATE_INDEX = 4;
    private static final int RESERVATION_DATE_INDEX = 5;
    private static final int AMOUNT_INDEX = 6;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReservationEntity reservation = entities.get(rowIndex);
        switch (columnIndex) {
            case RESERVATION_STATUS_INDEX:
                return reservation.getReservationStatus();
            case PAYMENT_INDEX:
                return reservation.getPayment();
            case CLIENT_INDEX:
                return reservation.getClient();
            case FROM_DATE_INDEX:
                return DateFormatter.formatDate(reservation.getFromDate());
            case TO_DATE_INDEX:
                return DateFormatter.formatDate(reservation.getToDate());
            case RESERVATION_DATE_INDEX:
                return DateFormatter.formatDate(reservation.getReservationDate());
            case AMOUNT_INDEX:
                return reservation.getAmount();
            default:
                return Strings.EMPTY;
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

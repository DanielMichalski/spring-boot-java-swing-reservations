package pl.dmichalski.reservations.business.ui.room_x_reservation.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.entity.RoomXReservation;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class RoomXReservationTableModel extends DefaultTableModel<RoomXReservation> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomXReservation roomXReservation = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return roomXReservation.getReservation();
            case 1:
                return roomXReservation.getRoom();
            case 2:
                return roomXReservation.getRoomPrice();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.ROOM,
                ConstMessages.Labels.ROOM_TYPE,
                ConstMessages.Labels.BASIC_RATE};
    }
}

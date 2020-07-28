package pl.dmichalski.reservations.business.ui.forms.room_x_reservation.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomXReservationTableModel extends DefaultTableModel<RoomXReservationEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomXReservationEntity roomXReservation = entities.get(rowIndex);
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
                ConstMessagesEN.Labels.ROOM,
                ConstMessagesEN.Labels.ROOM_TYPE,
                ConstMessagesEN.Labels.BASIC_RATE};
    }
}

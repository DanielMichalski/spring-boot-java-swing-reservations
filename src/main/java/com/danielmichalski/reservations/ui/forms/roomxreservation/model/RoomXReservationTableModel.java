package com.danielmichalski.reservations.ui.forms.roomxreservation.model;

import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class RoomXReservationTableModel extends DefaultTableModel<RoomXReservationEntity> {

    private static final int ROOM_INDEX = 0;
    private static final int ROOM_TYPE_INDEX = 1;
    private static final int BASIC_RATE_INDEX = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomXReservationEntity roomXReservation = entities.get(rowIndex);
        switch (columnIndex) {
            case ROOM_INDEX:
                return roomXReservation.getReservation();
            case ROOM_TYPE_INDEX:
                return roomXReservation.getRoom();
            case BASIC_RATE_INDEX:
                return roomXReservation.getRoomPrice();
            default:
                return Strings.EMPTY;
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

package com.danielmichalski.reservations.ui.forms.room.model;

import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class RoomTableModel extends DefaultTableModel<RoomEntity> {

    private static final int ROOM_STATUS_INDEX = 0;
    private static final int ROOM_NUMBER_OF_PEOPLE_INDEX = 1;
    private static final int ROOM_DESCRIPTION_INDEX = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomEntity room = entities.get(rowIndex);
        switch (columnIndex) {
            case ROOM_STATUS_INDEX:
                return room.getRoomStatus();
            case ROOM_NUMBER_OF_PEOPLE_INDEX:
                return room.getNumberOfPeople();
            case ROOM_DESCRIPTION_INDEX:
                return room.getDescription();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM_STATUS,
                ConstMessagesEN.Labels.ROOM_NUMBER_OF_PEOPLE,
                ConstMessagesEN.Labels.ROOM_DESCRIPTION};
    }
}

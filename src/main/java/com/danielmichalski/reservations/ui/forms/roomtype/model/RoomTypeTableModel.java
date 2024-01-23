package com.danielmichalski.reservations.ui.forms.roomtype.model;

import com.danielmichalski.reservations.domain.room.entity.RoomTypeEntity;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeTableModel extends DefaultTableModel<RoomTypeEntity> {

    private static final int ROOM_TYPE_INDEX = 0;
    private static final int ROOM_MULTIPLIER_INDEX = 1;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomTypeEntity roomType = entities.get(rowIndex);
        switch (columnIndex) {
            case ROOM_TYPE_INDEX:
                return roomType.getDescription();
            case ROOM_MULTIPLIER_INDEX:
                return roomType.getMultiplier();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM_TYPE,
                ConstMessagesEN.Labels.ROOM_MULTIPLIER};
    }
}

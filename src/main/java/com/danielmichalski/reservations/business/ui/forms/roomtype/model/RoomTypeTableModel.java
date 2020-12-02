package com.danielmichalski.reservations.business.ui.forms.roomtype.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

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

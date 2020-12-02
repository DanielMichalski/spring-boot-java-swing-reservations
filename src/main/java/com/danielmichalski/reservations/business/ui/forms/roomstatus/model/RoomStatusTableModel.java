package com.danielmichalski.reservations.business.ui.forms.roomstatus.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomStatusTableModel extends DefaultTableModel<RoomStatusEntity> {

    private static final int ROOM_STATUS_INDEX = 0;
    private static final int ROOM_STATUS_DESCRIPTION_INDEX = 1;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomStatusEntity roomStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case ROOM_STATUS_INDEX:
                return roomStatus.getStatus();
            case ROOM_STATUS_DESCRIPTION_INDEX:
                return roomStatus.getStatusDescription();
            default:
                return Strings.EMPTY;
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM_STATUS,
                ConstMessagesEN.Labels.ROOM_STATUS_DESCRIPTION};
    }
}

package com.danielmichalski.reservations.ui.reports.roomstatuses.model;

import com.danielmichalski.reservations.domain.room.dto.RoomStatusesCountDto;
import com.danielmichalski.reservations.ui.shared.model.DefaultTableModel;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class RoomStatusReportModel extends DefaultTableModel<RoomStatusesCountDto> {

    private static final int ROOM_STATUS_INDEX = 0;
    private static final int NUMBER_OF_COUNT_INDEX = 1;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM_STATUS,
                ConstMessagesEN.Labels.NUMBER_OF_COUNT
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomStatusesCountDto roomStatusesCount = entities.get(rowIndex);

        switch (columnIndex) {
            case ROOM_STATUS_INDEX:
                return roomStatusesCount.status();
            case NUMBER_OF_COUNT_INDEX:
                return roomStatusesCount.count();
            default:
                return Strings.EMPTY;
        }
    }

}

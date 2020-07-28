package pl.dmichalski.reservations.business.ui.reports.room_statuses.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.dto.room.RoomStatusesCountDto;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomStatusReportModel extends DefaultTableModel<RoomStatusesCountDto> {

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
            case 0:
                return roomStatusesCount.getStatus();
            case 1:
                return roomStatusesCount.getCount();
            default:
                return "";
        }
    }

}

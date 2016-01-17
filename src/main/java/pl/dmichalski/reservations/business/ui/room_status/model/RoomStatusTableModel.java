package pl.dmichalski.reservations.business.ui.room_status.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class RoomStatusTableModel extends DefaultTableModel<RoomStatus> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomStatus roomStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return roomStatus.getRoomStatus();
            case 1:
                return roomStatus.getDescription();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.ROOM_STATUS,
                ConstMessages.Labels.ROOM_STATUS_DESCRIPTION};
    }
}

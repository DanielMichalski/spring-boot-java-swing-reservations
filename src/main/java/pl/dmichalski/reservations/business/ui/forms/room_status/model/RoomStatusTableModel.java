package pl.dmichalski.reservations.business.ui.forms.room_status.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

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
                ConstMessagesEN.Labels.ROOM_STATUS,
                ConstMessagesEN.Labels.ROOM_STATUS_DESCRIPTION};
    }
}

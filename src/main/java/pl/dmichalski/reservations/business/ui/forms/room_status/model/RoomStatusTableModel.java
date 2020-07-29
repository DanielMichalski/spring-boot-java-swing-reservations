package pl.dmichalski.reservations.business.ui.forms.room_status.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomStatusTableModel extends DefaultTableModel<RoomStatusEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomStatusEntity roomStatus = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return roomStatus.getStatus();
            case 1:
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

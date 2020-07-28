package pl.dmichalski.reservations.business.ui.forms.room.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomTableModel extends DefaultTableModel<RoomEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomEntity room = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return room.getRoomStatus();
            case 1:
                return room.getNumberOfPeople();
            case 2:
                return room.getDescription();
            default:
                return "";
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

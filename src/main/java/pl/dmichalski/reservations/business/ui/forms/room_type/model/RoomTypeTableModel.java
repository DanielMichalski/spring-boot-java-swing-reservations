package pl.dmichalski.reservations.business.ui.forms.room_type.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class RoomTypeTableModel extends DefaultTableModel<RoomType> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomType roomType = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return roomType.getDescription();
            case 1:
                return roomType.getMultiplier();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM_TYPE,
                ConstMessagesEN.Labels.ROOM_MULTIPLIER};
    }
}

package pl.dmichalski.reservations.business.ui.rate.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class RateTableModel extends DefaultTableModel<Rate> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rate rate = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rate.getRoom();
            case 1:
                return rate.getRoomType();
            case 2:
                return rate.getBasicRate();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.ROOM,
                ConstMessages.Labels.ROOM_TYPE,
                ConstMessages.Labels.BASIC_RATE};
    }
}

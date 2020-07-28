package pl.dmichalski.reservations.business.ui.forms.rate.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RateTableModel extends DefaultTableModel<RateEntity> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RateEntity rate = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rate.getRoom();
            case 1:
                return rate.getRoomType();
            case 2:
                return rate.getDefaultRate();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Labels.ROOM,
                ConstMessagesEN.Labels.ROOM_TYPE,
                ConstMessagesEN.Labels.BASIC_RATE};
    }
}

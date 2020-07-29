package pl.dmichalski.reservations.business.ui.forms.rate.model;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RateTableModel extends DefaultTableModel<RateEntity> {

    private static final int ROOM_INDEX = 0;
    private static final int ROOM_TYPE_INDEX = 1;
    private static final int DEFAULT_RATE_INDEX = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RateEntity rate = entities.get(rowIndex);
        switch (columnIndex) {
            case ROOM_INDEX:
                return rate.getRoom();
            case ROOM_TYPE_INDEX:
                return rate.getRoomType();
            case DEFAULT_RATE_INDEX:
                return rate.getDefaultRate();
            default:
                return Strings.EMPTY;
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

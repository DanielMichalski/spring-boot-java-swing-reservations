package pl.dmichalski.reservations.business.ui.forms.rate.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomTypeComboBoxModel;
import pl.dmichalski.reservations.business.util.border.Borders;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RateFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final RoomComboBoxModel roomComboBoxModel;
    private final RoomTypeComboBoxModel roomTypeComboBoxModel;

    private JTextField rateTF;

    public RateFormPanel(RoomComboBoxModel roomComboBoxModel, RoomTypeComboBoxModel roomTypeComboBoxModel) {
        this.roomComboBoxModel = roomComboBoxModel;
        this.roomTypeComboBoxModel = roomTypeComboBoxModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel roomLbl = new JLabel(ConstMessagesEN.Labels.ROOM);
        JLabel roomTypeLbl = new JLabel(ConstMessagesEN.Labels.ROOM_TYPE);
        JLabel rateLbl = new JLabel(ConstMessagesEN.Labels.BASIC_RATE);

        JComboBox<RoomEntity> roomCB = new JComboBox<>(roomComboBoxModel);
        JComboBox<RoomTypeEntity> roomTypeCB = new JComboBox<>(roomTypeComboBoxModel);
        rateTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(roomLbl);
        add(roomCB);
        add(roomTypeLbl);
        add(roomTypeCB);
        add(rateLbl);
        add(rateTF);
    }

    public RateEntity getEntityFromForm() {
        Long roomRate = null;
        try {
            roomRate = Long.parseLong(rateTF.getText());
        } catch (Exception ignored) {
            // ignored
        }

        return new RateEntity(
                roomComboBoxModel.getSelectedItem(),
                roomTypeComboBoxModel.getSelectedItem(),
                roomRate
        );
    }

    public void clearForm() {
        rateTF.setText(Strings.EMPTY);
    }

}

package pl.dmichalski.reservations.business.ui.forms.room_type.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomTypeFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 2;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField descriptionTF;
    private JSpinner multiplierJS;

    public RoomTypeFormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel roomDescriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_TYPE_DESCRIPTION);
        JLabel roomMultiplierLbl = new JLabel(ConstMessagesEN.Labels.ROOM_MULTIPLIER);

        descriptionTF = new JTextField(TEXT_FIELD_COLUMNS);
        multiplierJS = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

        add(roomDescriptionLbl);
        add(descriptionTF);
        add(roomMultiplierLbl);
        add(multiplierJS);
    }

    public RoomType getEntityFromForm() {
        RoomType roomType = new RoomType();
        roomType.setDescription(descriptionTF.getText());
        roomType.setMultiplier((Integer) multiplierJS.getValue());
        return roomType;
    }

    public void clearForm() {
        descriptionTF.setText("");
    }

}

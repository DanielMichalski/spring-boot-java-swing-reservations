package com.danielmichalski.reservations.ui.forms.roomtype.view.modal;

import com.danielmichalski.reservations.domain.room.entity.RoomTypeEntity;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;

@Component
public class RoomTypeFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 2;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField descriptionTF;
    private JSpinner multiplierJS;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        final JLabel roomDescriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_TYPE_DESCRIPTION);
        final JLabel roomMultiplierLbl = new JLabel(ConstMessagesEN.Labels.ROOM_MULTIPLIER);

        descriptionTF = new JTextField(TEXT_FIELD_COLUMNS);
        multiplierJS = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

        add(roomDescriptionLbl);
        add(descriptionTF);
        add(roomMultiplierLbl);
        add(multiplierJS);
    }

    public RoomTypeEntity getEntityFromForm() {
        return new RoomTypeEntity(
                descriptionTF.getText(),
                (Integer) multiplierJS.getValue()
        );
    }

    public void clearForm() {
        descriptionTF.setText(Strings.EMPTY);
    }

}

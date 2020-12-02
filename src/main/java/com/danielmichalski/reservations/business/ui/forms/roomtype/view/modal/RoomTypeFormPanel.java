package com.danielmichalski.reservations.business.ui.forms.roomtype.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

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
    private void preparePanel() {
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

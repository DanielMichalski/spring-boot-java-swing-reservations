package com.danielmichalski.reservations.ui.forms.roomstatus.view.modal;

import com.danielmichalski.reservations.domain.room.entity.RoomStatusEntity;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

@Component
public class RoomStatusFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 2;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField roomStatusTF;
    private JTextField roomStatusDescriptionTF;

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
        final JLabel roomStatusLbl = new JLabel(ConstMessagesEN.Labels.ROOM_STATUS);
        final JLabel roomStatusDescriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_STATUS_DESCRIPTION);

        roomStatusTF = new JTextField(TEXT_FIELD_COLUMNS);
        roomStatusDescriptionTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(roomStatusLbl);
        add(roomStatusTF);
        add(roomStatusDescriptionLbl);
        add(roomStatusDescriptionTF);
    }

    public RoomStatusEntity getEntityFromForm() {
        return new RoomStatusEntity(
                roomStatusTF.getText(),
                roomStatusDescriptionTF.getText()
        );
    }

    public void clearForm() {
        roomStatusTF.setText(Strings.EMPTY);
        roomStatusDescriptionTF.setText(Strings.EMPTY);
    }

}

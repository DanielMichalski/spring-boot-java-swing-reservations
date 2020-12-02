package com.danielmichalski.reservations.business.ui.forms.roomstatus.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

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
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel roomStatusLbl = new JLabel(ConstMessagesEN.Labels.ROOM_STATUS);
        JLabel roomStatusDescriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_STATUS_DESCRIPTION);

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

package pl.dmichalski.reservations.business.ui.forms.room_status.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomStatusFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 2;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField roomStatusTF;
    private JTextField roomStatusDescriptionTF;

    public RoomStatusFormPanel() {
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

    public RoomStatus getEntityFromForm() {
        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setRoomStatus(roomStatusTF.getText());
        roomStatus.setDescription(roomStatusDescriptionTF.getText());
        return roomStatus;
    }

    public void clearForm() {
        roomStatusTF.setText("");
        roomStatusDescriptionTF.setText("");
    }

}

package pl.dmichalski.reservations.business.ui.forms.room_status.view.modal;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.util.border.Borders;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

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

    public RoomStatusEntity getEntityFromForm() {
        return new RoomStatusEntity(
                roomStatusTF.getText(),
                roomStatusDescriptionTF.getText()
        );
    }

    public void clearForm() {
        roomStatusTF.setText("");
        roomStatusDescriptionTF.setText("");
    }

}

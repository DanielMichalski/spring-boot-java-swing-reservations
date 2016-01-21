package pl.dmichalski.reservations.business.ui.forms.room.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.ui.forms.room.model.RoomStatusComboBoxModel;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JComboBox<RoomStatus> roomStatusCB;
    private JSpinner numberOfPeopleJS;
    private JTextField descriptionTf;

    private RoomStatusComboBoxModel roomComboBoxModel;

    @Autowired
    public RoomFormPanel(RoomStatusComboBoxModel roomComboBoxModel) {
        this.roomComboBoxModel = roomComboBoxModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel roomStatusLbl = new JLabel(ConstMessagesEN.Labels.ROOM_STATUS);
        JLabel numberOfPeopleLbl = new JLabel(ConstMessagesEN.Labels.ROOM_NUMBER_OF_PEOPLE);
        JLabel descriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_DESCRIPTION);

        roomStatusCB = new JComboBox<>(roomComboBoxModel);
        numberOfPeopleJS = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        descriptionTf= new JTextField(TEXT_FIELD_COLUMNS);

        add(roomStatusLbl);
        add(roomStatusCB);
        add(numberOfPeopleLbl);
        add(numberOfPeopleJS);
        add(descriptionLbl);
        add(descriptionTf);
    }

    public Room getEntityFromForm() {
        Room room = new Room();
        room.setRoomStatus(roomComboBoxModel.getSelectedItem());
        room.setNumberOfPeople((Integer) numberOfPeopleJS.getValue());
        room.setDescription(descriptionTf.getText());
        return room;
    }

    public void clearForm() {
        descriptionTf.setText("");
    }

}

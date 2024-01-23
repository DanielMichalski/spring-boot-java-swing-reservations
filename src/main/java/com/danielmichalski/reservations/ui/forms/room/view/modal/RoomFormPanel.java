package com.danielmichalski.reservations.ui.forms.room.view.modal;

import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.domain.room.entity.RoomStatusEntity;
import com.danielmichalski.reservations.ui.forms.room.model.RoomStatusComboBoxModel;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;

@Component
public class RoomFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final RoomStatusComboBoxModel roomComboBoxModel;

    private JSpinner numberOfPeopleJS;
    private JTextField descriptionTf;

    public RoomFormPanel(RoomStatusComboBoxModel roomComboBoxModel) {
        this.roomComboBoxModel = roomComboBoxModel;
    }

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
        final JLabel numberOfPeopleLbl = new JLabel(ConstMessagesEN.Labels.ROOM_NUMBER_OF_PEOPLE);
        final JLabel descriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_DESCRIPTION);

        final JComboBox<RoomStatusEntity> roomStatusCB = new JComboBox<>(roomComboBoxModel);
        numberOfPeopleJS = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        descriptionTf = new JTextField(TEXT_FIELD_COLUMNS);

        add(roomStatusLbl);
        add(roomStatusCB);
        add(numberOfPeopleLbl);
        add(numberOfPeopleJS);
        add(descriptionLbl);
        add(descriptionTf);
    }

    public RoomEntity getEntityFromForm() {
        return new RoomEntity(
                roomComboBoxModel.getSelectedItem(),
                (Integer) numberOfPeopleJS.getValue(),
                descriptionTf.getText()
        );
    }

    public void clearForm() {
        descriptionTf.setText(Strings.EMPTY);
    }

}

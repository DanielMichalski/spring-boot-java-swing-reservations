package pl.dmichalski.reservations.business.ui.forms.room.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.ui.forms.room.model.RoomStatusComboBoxModel;
import pl.dmichalski.reservations.business.util.border.Borders;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

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
        JLabel numberOfPeopleLbl = new JLabel(ConstMessagesEN.Labels.ROOM_NUMBER_OF_PEOPLE);
        JLabel descriptionLbl = new JLabel(ConstMessagesEN.Labels.ROOM_DESCRIPTION);

        JComboBox<RoomStatusEntity> roomStatusCB = new JComboBox<>(roomComboBoxModel);
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

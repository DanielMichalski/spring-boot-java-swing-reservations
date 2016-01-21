package pl.dmichalski.reservations.business.ui.forms.rate.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomTypeComboBoxModel;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RateFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JComboBox<Room> roomCB;
    private JComboBox<RoomType> roomTypeCB;
    private JTextField rateTF;

    private RoomComboBoxModel roomComboBoxModel;
    private RoomTypeComboBoxModel roomTypeComboBoxModel;

    @Autowired
    public RateFormPanel(RoomComboBoxModel roomComboBoxModel, RoomTypeComboBoxModel roomTypeComboBoxModel) {
        this.roomComboBoxModel = roomComboBoxModel;
        this.roomTypeComboBoxModel = roomTypeComboBoxModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel roomLbl = new JLabel(ConstMessagesEN.Labels.ROOM);
        JLabel roomTypeLbl = new JLabel(ConstMessagesEN.Labels.ROOM_TYPE);
        JLabel rateLbl = new JLabel(ConstMessagesEN.Labels.BASIC_RATE);

        roomCB = new JComboBox<>(roomComboBoxModel);
        roomTypeCB = new JComboBox<>(roomTypeComboBoxModel);
        rateTF= new JTextField(TEXT_FIELD_COLUMNS);

        add(roomLbl);
        add(roomCB);
        add(roomTypeLbl);
        add(roomTypeCB);
        add(rateLbl);
        add(rateTF);
    }

    public Rate getEntityFromForm() {
        Rate rate = new Rate();
        rate.setRoom(roomComboBoxModel.getSelectedItem());
        rate.setRoomType(roomTypeComboBoxModel.getSelectedItem());
        try {
            rate.setBasicRate(Long.parseLong(rateTF.getText()));
        } catch (Exception ignored) {}
        return rate;
    }

    public void clearForm() {
        rateTF.setText("");
    }

}

package com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomXReservationPK;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.model.ReservationsComboBoxModel;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class RoomXReservationFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final ReservationsComboBoxModel reservationsComboBoxModel;
    private final RoomComboBoxModel roomComboBoxModel;

    private JTextField priceTF;

    public RoomXReservationFormPanel(ReservationsComboBoxModel reservationsComboBoxModel, RoomComboBoxModel roomComboBoxModel) {
        this.reservationsComboBoxModel = reservationsComboBoxModel;
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
        JLabel reservationLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION);
        JLabel roomLbl = new JLabel(ConstMessagesEN.Labels.ROOM);
        JLabel priceLbl = new JLabel(ConstMessagesEN.Labels.PRICE);

        JComboBox<ReservationEntity> reservationCB = new JComboBox<>(reservationsComboBoxModel);
        JComboBox<RoomEntity> roomCB = new JComboBox<>(roomComboBoxModel);
        priceTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(reservationLbl);
        add(reservationCB);
        add(roomLbl);
        add(roomCB);
        add(priceLbl);
        add(priceTF);
    }

    public RoomXReservationEntity getEntityFromForm() {
        RoomEntity room = roomComboBoxModel.getSelectedItem();
        ReservationEntity reservation = reservationsComboBoxModel.getSelectedItem();
        RoomXReservationEntity roomXReservation = new RoomXReservationEntity(new RoomXReservationPK(room, reservation));
        try {
            roomXReservation.setRoomPrice(Integer.parseInt(priceTF.getText()));
        } catch (NumberFormatException ignored) {
            // ignored
        }
        return roomXReservation;
    }

    public void clearForm() {
        priceTF.setText(Strings.EMPTY);
    }

}

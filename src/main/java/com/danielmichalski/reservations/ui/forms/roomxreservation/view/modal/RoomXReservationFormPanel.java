package com.danielmichalski.reservations.ui.forms.roomxreservation.view.modal;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import com.danielmichalski.reservations.domain.room.entity.RoomXReservationPK;
import com.danielmichalski.reservations.ui.forms.rate.model.RoomComboBoxModel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.model.ReservationsComboBoxModel;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

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

    public RoomXReservationFormPanel(ReservationsComboBoxModel reservationsComboBoxModel,
                                     RoomComboBoxModel roomComboBoxModel) {
        this.reservationsComboBoxModel = reservationsComboBoxModel;
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
        final JLabel reservationLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION);
        final JLabel roomLbl = new JLabel(ConstMessagesEN.Labels.ROOM);
        final JLabel priceLbl = new JLabel(ConstMessagesEN.Labels.PRICE);

        final JComboBox<ReservationEntity> reservationCB = new JComboBox<>(reservationsComboBoxModel);
        final JComboBox<RoomEntity> roomCB = new JComboBox<>(roomComboBoxModel);
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

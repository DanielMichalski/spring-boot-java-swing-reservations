package pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddRoomXReservationFame extends JDialog {

    private RoomXReservationFormPanel formPanel;
    private RoomXReservationFormBtnPanel formBtnPanel;

    @Autowired
    public AddRoomXReservationFame(RoomXReservationFormPanel formPanel, RoomXReservationFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ROOM_X_RESERVATION_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public RoomXReservationFormPanel getFormPanel() {
        return formPanel;
    }

    public RoomXReservationFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

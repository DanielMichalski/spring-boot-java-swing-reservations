package pl.dmichalski.reservations.business.ui.forms.reservation.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddReservationFrame extends JDialog {

    private ReservationFormPanel formPanel;
    private ReservationFormBtnPanel formBtnPanel;

    @Autowired
    public AddReservationFrame(ReservationFormPanel formPanel, ReservationFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.RESERVATION_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public ReservationFormPanel getFormPanel() {
        return formPanel;
    }

    public ReservationFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

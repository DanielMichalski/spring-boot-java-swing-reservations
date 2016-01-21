package pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class ReservationStatusFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 1;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField reservationStatusTF;

    public ReservationStatusFormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel reservationStatusLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION_STATUS);
        reservationStatusTF = new JTextField(TEXT_FIELD_COLUMNS);
        add(reservationStatusLbl);
        add(reservationStatusTF);
    }

    public ReservationStatus getEntityFromForm() {
        ReservationStatus reservationStatus = new ReservationStatus();
        reservationStatus.setReservationStatus(reservationStatusTF.getText());
        return reservationStatus;
    }

    public void clearForm() {
        reservationStatusTF.setText("");
    }

}

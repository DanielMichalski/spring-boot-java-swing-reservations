package com.danielmichalski.reservations.ui.forms.reservationstatus.view.modal;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

@Component
public class ReservationStatusFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 1;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField reservationStatusTF;

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
        JLabel reservationStatusLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION_STATUS);
        reservationStatusTF = new JTextField(TEXT_FIELD_COLUMNS);
        add(reservationStatusLbl);
        add(reservationStatusTF);
    }

    public ReservationStatusEntity getEntityFromForm() {
        return new ReservationStatusEntity(
                reservationStatusTF.getText()
        );
    }

    public void clearForm() {
        reservationStatusTF.setText(Strings.EMPTY);
    }

}

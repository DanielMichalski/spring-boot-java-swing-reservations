package com.danielmichalski.reservations.ui.forms.reservation.view;

import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

@Component
@AllArgsConstructor
@Getter
public class ReservationTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 300;

    private final ReservationTablePanel tablePanel;
    private final ReservationTableBtnPanel tableBtnPanel;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.RESERVATIONS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

}

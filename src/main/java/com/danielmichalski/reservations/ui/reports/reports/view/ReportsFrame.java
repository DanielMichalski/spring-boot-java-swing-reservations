package com.danielmichalski.reservations.ui.reports.reports.view;

import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.util.ui.LookAndFeelUtils;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;

@Component
@Getter
public class ReportsFrame extends JFrame {

    private JButton paymentMethodReportBtn;
    private JButton roomStatusesReportBtn;
    private JButton clientReservationsReportBtn;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessagesEN.Labels.REPORTS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(3, 1, 20, 20));
    }

    private void initComponents() {
        paymentMethodReportBtn = new JButton(ConstMessagesEN.Labels.PAYMENT_METHODS);
        roomStatusesReportBtn = new JButton(ConstMessagesEN.Labels.ROOM_STATUSES);
        clientReservationsReportBtn = new JButton(ConstMessagesEN.Labels.CLIENT_RESERVATIONS);

        add(paymentMethodReportBtn);
        add(roomStatusesReportBtn);
        add(clientReservationsReportBtn);
    }

}

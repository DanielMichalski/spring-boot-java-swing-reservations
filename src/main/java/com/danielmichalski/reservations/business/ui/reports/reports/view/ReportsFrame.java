package com.danielmichalski.reservations.business.ui.reports.reports.view;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.ui.LookAndFeelUtils;

@Component
@Getter
public class ReportsFrame extends JFrame {

    private JButton paymentMethodReportBtn;
    private JButton roomStatusesReportBtn;
    private JButton clientReservationsReportBtn;

    @PostConstruct
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

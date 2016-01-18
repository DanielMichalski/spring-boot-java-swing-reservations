package pl.dmichalski.reservations.business.ui.reports.reports.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;

@Component
public class ReportsFrame extends JFrame {

    private JButton paymentMethodReportBtn;
    private JButton roomStatusesReportBtn;
    private JButton clientReservationsReportBtn;

    public ReportsFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessages.Labels.REPORTS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(3, 1, 20, 20));
    }

    private void initComponents() {
        paymentMethodReportBtn = new JButton(ConstMessages.Labels.PAYMENT_METHODS);
        roomStatusesReportBtn = new JButton(ConstMessages.Labels.ROOM_STATUSES);
        clientReservationsReportBtn = new JButton(ConstMessages.Labels.CLIENT_RESERVATIONS);

        add(paymentMethodReportBtn);
        add(roomStatusesReportBtn);
        add(clientReservationsReportBtn);
    }

    public JButton paymentMethodReportBtn() {
        return paymentMethodReportBtn;
    }

    public JButton getRoomStatusesReportBtn() {
        return roomStatusesReportBtn;
    }

    public JButton getClientReservationsReportBtn() {
        return clientReservationsReportBtn;
    }
}

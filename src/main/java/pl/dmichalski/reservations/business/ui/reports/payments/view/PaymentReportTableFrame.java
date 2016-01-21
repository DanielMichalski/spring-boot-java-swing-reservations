package pl.dmichalski.reservations.business.ui.reports.payments.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class PaymentReportTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private PaymentReportTablePanel tablePanel;

    @Autowired
    public PaymentReportTableFrame(PaymentReportTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.PAYMENT_METHODS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
    }

    public PaymentReportTablePanel getTablePanel() {
        return tablePanel;
    }
}

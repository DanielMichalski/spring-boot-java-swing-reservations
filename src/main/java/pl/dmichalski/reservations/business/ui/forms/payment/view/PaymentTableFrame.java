package pl.dmichalski.reservations.business.ui.forms.payment.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class PaymentTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private PaymentTablePanel tablePanel;
    private PaymentTableBtnPanel tableBtnPanel;

    @Autowired
    public PaymentTableFrame(PaymentTableBtnPanel tableBtnPanel, PaymentTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.PAYMENTS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public PaymentTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public PaymentTablePanel getTablePanel() {
        return tablePanel;
    }
}

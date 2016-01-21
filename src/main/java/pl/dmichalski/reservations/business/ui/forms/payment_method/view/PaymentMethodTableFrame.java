package pl.dmichalski.reservations.business.ui.forms.payment_method.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class PaymentMethodTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private PaymentMethodTablePanel tablePanel;
    private PaymentMethodTableBtnPanel tableBtnPanel;

    @Autowired
    public PaymentMethodTableFrame(PaymentMethodTableBtnPanel tableBtnPanel, PaymentMethodTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
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
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public PaymentMethodTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public PaymentMethodTablePanel getTablePanel() {
        return tablePanel;
    }
}

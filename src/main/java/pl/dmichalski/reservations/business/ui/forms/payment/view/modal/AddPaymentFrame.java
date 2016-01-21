package pl.dmichalski.reservations.business.ui.forms.payment.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddPaymentFrame extends JDialog {

    private PaymentFormPanel formPanel;
    private PaymentFormBtnPanel formBtnPanel;

    @Autowired
    public AddPaymentFrame(PaymentFormPanel formPanel, PaymentFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.PAYMENT_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public PaymentFormPanel getFormPanel() {
        return formPanel;
    }

    public PaymentFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

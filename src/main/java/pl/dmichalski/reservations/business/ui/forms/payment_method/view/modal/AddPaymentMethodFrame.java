package pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddPaymentMethodFrame extends JDialog {

    private PaymentMethodFormPanel formPanel;
    private PaymentMethodFormBtnPanel formBtnPanel;

    @Autowired
    public AddPaymentMethodFrame(PaymentMethodFormPanel formPanel, PaymentMethodFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.PAYMENT_METHOD_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public PaymentMethodFormPanel getFormPanel() {
        return formPanel;
    }

    public PaymentMethodFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

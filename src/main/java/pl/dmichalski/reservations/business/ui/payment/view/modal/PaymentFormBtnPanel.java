package pl.dmichalski.reservations.business.ui.payment.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessages;

import javax.swing.*;

@Component
public class PaymentFormBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    public PaymentFormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessages.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessages.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}

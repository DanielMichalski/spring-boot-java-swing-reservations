package pl.dmichalski.reservations.business.ui.forms.payment.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class PaymentTableBtnPanel extends JPanel {

    private JButton addBtn;
    private JButton removeBtn;

    public PaymentTableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(addBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}

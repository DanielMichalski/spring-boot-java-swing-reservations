package pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class PaymentMethodFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 1;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField paymentMethodTF;

    public PaymentMethodFormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel paymentMethodLbl = new JLabel(ConstMessagesEN.Labels.PAYMENT_METHOD);
        paymentMethodTF = new JTextField(TEXT_FIELD_COLUMNS);
        add(paymentMethodLbl);
        add(paymentMethodTF);
    }

    public PaymentMethod getEntityFromForm() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(paymentMethodTF.getText());
        return paymentMethod;
    }

    public void clearForm() {
        paymentMethodTF.setText("");
    }

}

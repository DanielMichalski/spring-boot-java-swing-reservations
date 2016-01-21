package pl.dmichalski.reservations.business.ui.forms.payment.view.modal;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Payment;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.ui.forms.payment.model.PaymentMethodComboBoxModel;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class PaymentFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JComboBox<PaymentMethod> paymentMethodCB;
    private JTextField valueTF;
    private JDateChooser dateOfPaymentDC;

    private PaymentMethodComboBoxModel paymentMethodComboBoxModel;

    @Autowired
    public PaymentFormPanel(PaymentMethodComboBoxModel paymentMethodComboBoxModel) {
        this.paymentMethodComboBoxModel = paymentMethodComboBoxModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel paymentMethodLbl = new JLabel(ConstMessagesEN.Labels.PAYMENT_METHOD);
        JLabel valueLbl = new JLabel(ConstMessagesEN.Labels.VALUE);
        JLabel dateOfPaymentLbl = new JLabel(ConstMessagesEN.Labels.DATE_OF_PAYMENT);

        paymentMethodCB = new JComboBox<>(paymentMethodComboBoxModel);
        valueTF = new JTextField(TEXT_FIELD_COLUMNS);
        dateOfPaymentDC= new JDateChooser();

        add(paymentMethodLbl);
        add(paymentMethodCB);
        add(valueLbl);
        add(valueTF);
        add(dateOfPaymentLbl);
        add(dateOfPaymentDC);
    }

    public Payment getEntityFromForm() {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethodComboBoxModel.getSelectedItem());
        try {
            payment.setValue(Long.valueOf(valueTF.getText()));
        } catch (NumberFormatException ignored) {}
        payment.setDateOfPayments(dateOfPaymentDC.getDate());
        return payment;
    }

    public void clearForm() {
        valueTF.setText("");
    }

}

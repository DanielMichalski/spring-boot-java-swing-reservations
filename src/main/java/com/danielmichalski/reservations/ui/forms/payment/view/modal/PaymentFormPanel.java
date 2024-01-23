package com.danielmichalski.reservations.ui.forms.payment.view.modal;

import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import com.danielmichalski.reservations.ui.forms.payment.model.PaymentMethodComboBoxModel;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.toedter.calendar.JDateChooser;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

@Component
public class PaymentFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final PaymentMethodComboBoxModel paymentMethodComboBoxModel;

    private JTextField valueTF;
    private JDateChooser dateOfPaymentDC;

    public PaymentFormPanel(PaymentMethodComboBoxModel paymentMethodComboBoxModel) {
        this.paymentMethodComboBoxModel = paymentMethodComboBoxModel;
    }

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        final JLabel paymentMethodLbl = new JLabel(ConstMessagesEN.Labels.PAYMENT_METHOD);
        final JLabel valueLbl = new JLabel(ConstMessagesEN.Labels.VALUE);
        final JLabel dateOfPaymentLbl = new JLabel(ConstMessagesEN.Labels.DATE_OF_PAYMENT);

        final JComboBox<PaymentMethodEntity> paymentMethodCB = new JComboBox<>(paymentMethodComboBoxModel);
        valueTF = new JTextField(TEXT_FIELD_COLUMNS);
        dateOfPaymentDC = new JDateChooser();

        add(paymentMethodLbl);
        add(paymentMethodCB);
        add(valueLbl);
        add(valueTF);
        add(dateOfPaymentLbl);
        add(dateOfPaymentDC);
    }

    public PaymentEntity getEntityFromForm() {
        Long payment = null;
        try {
            payment = Long.valueOf(valueTF.getText());
        } catch (NumberFormatException ignored) {
            // ignored
        }

        return new PaymentEntity(
                paymentMethodComboBoxModel.getSelectedItem(),
                payment,
                dateOfPaymentDC.getDate()
        );
    }

    public void clearForm() {
        valueTF.setText(Strings.EMPTY);
    }

}

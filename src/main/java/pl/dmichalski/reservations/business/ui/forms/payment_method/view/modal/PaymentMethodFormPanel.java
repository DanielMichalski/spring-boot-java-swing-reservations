package pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import pl.dmichalski.reservations.business.util.border.Borders;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

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

    public PaymentMethodEntity getEntityFromForm() {
        return new PaymentMethodEntity(
                paymentMethodTF.getText()
        );
    }

    public void clearForm() {
        paymentMethodTF.setText(Strings.EMPTY);
    }

}

package com.danielmichalski.reservations.ui.forms.reservation.view.modal;

import com.danielmichalski.reservations.commons.time.CurrentTimeService;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.ui.forms.reservation.model.ClientComboBoxModel;
import com.danielmichalski.reservations.ui.forms.reservation.model.PaymentComboBoxModel;
import com.danielmichalski.reservations.ui.forms.reservation.model.ReservationStatusComboBoxModel;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.toedter.calendar.JDateChooser;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

@Component
public class ReservationFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final CurrentTimeService currentTimeService;
    private final ReservationStatusComboBoxModel reservationStatusComboBoxModel;
    private final PaymentComboBoxModel paymentComboBoxModel;
    private final ClientComboBoxModel clientComboBoxModel;

    private JDateChooser dateFromDC;
    private JDateChooser dateToDC;
    private JTextField amountTF;

    public ReservationFormPanel(CurrentTimeService currentTimeService,
                                ReservationStatusComboBoxModel reservationStatusComboBoxModel,
                                PaymentComboBoxModel paymentComboBoxModel,
                                ClientComboBoxModel clientComboBoxModel) {
        this.currentTimeService = currentTimeService;
        this.reservationStatusComboBoxModel = reservationStatusComboBoxModel;
        this.paymentComboBoxModel = paymentComboBoxModel;
        this.clientComboBoxModel = clientComboBoxModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        final JLabel reservationStatusLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION_STATUS);
        final JLabel paymentLbl = new JLabel(ConstMessagesEN.Labels.PAYMENT);
        final JLabel clientLbl = new JLabel(ConstMessagesEN.Labels.CLIENT);
        final JLabel dateFromLbl = new JLabel(ConstMessagesEN.Labels.FROM_DATE);
        final JLabel dateToLbl = new JLabel(ConstMessagesEN.Labels.TO_DATE);
        final JLabel amountLbl = new JLabel(ConstMessagesEN.Labels.AMOUNT);

        final JComboBox<ReservationStatusEntity> reservationStatusCB = new JComboBox<>(reservationStatusComboBoxModel);
        final JComboBox<PaymentEntity> paymentCB = new JComboBox<>(paymentComboBoxModel);
        final JComboBox<ClientEntity> clientCB = new JComboBox<>(clientComboBoxModel);
        dateFromDC = new JDateChooser();
        dateToDC = new JDateChooser();
        amountTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(reservationStatusLbl);
        add(reservationStatusCB);
        add(paymentLbl);
        add(paymentCB);
        add(clientLbl);
        add(clientCB);
        add(dateFromLbl);
        add(dateFromDC);
        add(dateToLbl);
        add(dateToDC);
        add(amountLbl);
        add(amountTF);
    }

    public ReservationEntity getEntityFromForm() {
        Long amount = null;
        try {
            amount = Long.parseLong(amountTF.getText());
        } catch (NumberFormatException ignored) {
            // ignored
        }

        return new ReservationEntity(
                reservationStatusComboBoxModel.getSelectedItem(),
                paymentComboBoxModel.getSelectedItem(),
                clientComboBoxModel.getSelectedItem(),
                dateFromDC.getDate(),
                dateToDC.getDate(),
                currentTimeService.getCurrentDate(),
                amount
        );
    }

    public void clearForm() {
        amountTF.setText(Strings.EMPTY);
    }

}

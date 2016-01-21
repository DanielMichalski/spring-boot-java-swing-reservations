package pl.dmichalski.reservations.business.ui.forms.reservation.view.modal;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.entity.Payment;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.time.CurrentTimeService;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.ClientComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.PaymentComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.ReservationStatusComboBoxModel;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class ReservationFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JDateChooser dateFromDC;
    private JDateChooser dateToDC;
    private JTextField amountTF;

    private CurrentTimeService currentTimeService;
    private ReservationStatusComboBoxModel reservationStatusComboBoxModel;
    private PaymentComboBoxModel paymentComboBoxModel;
    private ClientComboBoxModel clientComboBoxModel;

    @Autowired
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
        JLabel reservationStatusLbl = new JLabel(ConstMessagesEN.Labels.RESERVATION_STATUS);
        JLabel paymentLbl = new JLabel(ConstMessagesEN.Labels.PAYMENT);
        JLabel clientLbl = new JLabel(ConstMessagesEN.Labels.CLIENT);
        JLabel dateFromLbl = new JLabel(ConstMessagesEN.Labels.FROM_DATE);
        JLabel dateToLbl = new JLabel(ConstMessagesEN.Labels.TO_DATE);
        JLabel amountLbl = new JLabel(ConstMessagesEN.Labels.AMOUNT);

        JComboBox<ReservationStatus> reservationStatusCB = new JComboBox<>(reservationStatusComboBoxModel);
        JComboBox<Payment> paymentCB = new JComboBox<>(paymentComboBoxModel);
        JComboBox<Client> clientCB = new JComboBox<>(clientComboBoxModel);
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

    public Reservation getEntityFromForm() {
        Reservation reservation = new Reservation();
        reservation.setReservationStatus(reservationStatusComboBoxModel.getSelectedItem());
        reservation.setPayment(paymentComboBoxModel.getSelectedItem());
        reservation.setClient(clientComboBoxModel.getSelectedItem());
        reservation.setDateFrom(dateFromDC.getDate());
        reservation.setDateTo(dateToDC.getDate());
        reservation.setReservationDate(currentTimeService.getCurrentDate());
        try {
            reservation.setAmount(Long.parseLong(amountTF.getText()));
        } catch (NumberFormatException ignored) {}
        return reservation;
    }

    public void clearForm() {
        amountTF.setText("");
    }

}

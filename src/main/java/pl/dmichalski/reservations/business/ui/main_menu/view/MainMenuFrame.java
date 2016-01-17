package pl.dmichalski.reservations.business.ui.main_menu.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;

@Component
public class MainMenuFrame extends JFrame {

    private JButton addressesBtn;
    private JButton clientBtn;
    private JButton reservationStatusBtn;
    private JButton paymentMethodBtn;
    private JButton paymentBtn;
    private JButton reservationBtn;
    private JButton roomStatusBtn;
    private JButton roomTypeBtn;
    private JButton roomBtn;
    private JButton rateBtn;
    private JButton roomXReservationBtn;

    public MainMenuFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessages.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(6, 2, 20, 20));
    }

    private void initComponents() {
        addressesBtn = new JButton(ConstMessages.Labels.ADDRESSES);
        clientBtn = new JButton(ConstMessages.Labels.CLIENTS);
        reservationStatusBtn = new JButton(ConstMessages.Labels.RESERVATION_STATUSES);
        paymentMethodBtn = new JButton(ConstMessages.Labels.PAYMENT_METHODS);
        paymentBtn = new JButton(ConstMessages.Labels.PAYMENTS);
        reservationBtn = new JButton(ConstMessages.Labels.RESERVATIONS);
        roomStatusBtn = new JButton(ConstMessages.Labels.ROOM_STATUSES);
        roomTypeBtn = new JButton(ConstMessages.Labels.ROOM_TYPES);
        roomBtn = new JButton(ConstMessages.Labels.ROOMS);
        rateBtn = new JButton(ConstMessages.Labels.RATES);
        roomXReservationBtn = new JButton(ConstMessages.Labels.ROOM_X_RESERVATIONS);

        add(addressesBtn);
        add(clientBtn);
        add(reservationStatusBtn);
        add(paymentMethodBtn);
        add(paymentBtn);
        add(reservationBtn);
        add(roomStatusBtn);
        add(roomTypeBtn);
        add(roomBtn);
        add(rateBtn);
        add(roomXReservationBtn);
    }

    public JButton getAddressesBtn() {
        return addressesBtn;
    }

    public JButton getClientBtn() {
        return clientBtn;
    }

    public JButton getReservationStatusBtn() {
        return reservationStatusBtn;
    }

    public JButton getReservationBtn() {
        return reservationBtn;
    }

    public JButton getPaymentBtn() {
        return paymentBtn;
    }

    public JButton getPaymentMethodBtn() {
        return paymentMethodBtn;
    }

    public JButton getRoomStatusBtn() {
        return roomStatusBtn;
    }

    public JButton getRoomTypeBtn() {
        return roomTypeBtn;
    }

    public JButton getRoomBtn() {
        return roomBtn;
    }

    public JButton getRateBtn() {
        return rateBtn;
    }

    public JButton getRoomXReservationBtn() {
        return roomXReservationBtn;
    }
}

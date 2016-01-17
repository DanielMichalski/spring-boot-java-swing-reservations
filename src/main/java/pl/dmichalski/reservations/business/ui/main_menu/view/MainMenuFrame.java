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
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void initComponents() {
        addressesBtn = new JButton(ConstMessages.Labels.ADDRESSES);
        clientBtn = new JButton(ConstMessages.Labels.CLIENTS);
        reservationStatusBtn = new JButton(ConstMessages.Labels.RESERVATION_STATUSES);
        paymentMethodBtn = new JButton(ConstMessages.Labels.PAYMENT_METHODS);
        paymentBtn = new JButton(ConstMessages.Labels.PAYMENTS);
        reservationBtn = new JButton(ConstMessages.Labels.RESERVATIONS);

        add(addressesBtn);
        add(clientBtn);
        add(reservationStatusBtn);
        add(paymentMethodBtn);
        add(paymentBtn);
        add(reservationBtn);
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
}

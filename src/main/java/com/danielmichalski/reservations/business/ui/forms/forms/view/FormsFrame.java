package com.danielmichalski.reservations.business.ui.forms.forms.view;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.ui.LookAndFeelUtils;

@Component
@Getter
public class FormsFrame extends JFrame {

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

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessagesEN.Labels.FORMS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(6, 2, 20, 20));
    }

    private void initComponents() {
        addressesBtn = new JButton(ConstMessagesEN.Labels.ADDRESSES);
        clientBtn = new JButton(ConstMessagesEN.Labels.CLIENTS);
        reservationStatusBtn = new JButton(ConstMessagesEN.Labels.RESERVATION_STATUSES);
        paymentMethodBtn = new JButton(ConstMessagesEN.Labels.PAYMENT_METHODS);
        paymentBtn = new JButton(ConstMessagesEN.Labels.PAYMENTS);
        reservationBtn = new JButton(ConstMessagesEN.Labels.RESERVATIONS);
        roomStatusBtn = new JButton(ConstMessagesEN.Labels.ROOM_STATUSES);
        roomTypeBtn = new JButton(ConstMessagesEN.Labels.ROOM_TYPES);
        roomBtn = new JButton(ConstMessagesEN.Labels.ROOMS);
        rateBtn = new JButton(ConstMessagesEN.Labels.RATES);
        roomXReservationBtn = new JButton(ConstMessagesEN.Labels.ROOM_X_RESERVATIONS);

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

}

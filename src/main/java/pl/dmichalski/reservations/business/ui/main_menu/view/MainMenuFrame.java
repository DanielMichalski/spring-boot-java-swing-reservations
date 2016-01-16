package pl.dmichalski.reservations.business.ui.main_menu.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.LookAndFeelUtils;

import javax.swing.*;
import java.awt.*;

@Component
public class MainMenuFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;

    private JButton clientBtn;
    private JButton reservationBtn;
    private JButton addressesBtn;

    public MainMenuFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessages.FramesTitles.REGISTRATION_FRAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void initComponents() {
        clientBtn = new JButton(ConstMessages.Labels.CLIENTS);
        reservationBtn = new JButton(ConstMessages.Labels.RESERVATIONS);
        addressesBtn = new JButton(ConstMessages.Labels.ADDRESSES);

        add(clientBtn);
        add(reservationBtn);
        add(addressesBtn);
    }

    public JButton getClientBtn() {
        return clientBtn;
    }

    public JButton getReservationBtn() {
        return reservationBtn;
    }

    public JButton getAddressesBtn() {
        return addressesBtn;
    }
}

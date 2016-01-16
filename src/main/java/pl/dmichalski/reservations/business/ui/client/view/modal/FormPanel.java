package pl.dmichalski.reservations.business.ui.client.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessages;

import javax.swing.*;
import java.awt.*;

@Component
public class FormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField nameTF;
    private JTextField surnameTF;
    private JTextField peselTF;
    private JTextField phoneNumberTF;
    private JTextField emailTF;

    public FormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel nameLbl = new JLabel(ConstMessages.Labels.NAME);
        JLabel surnameLbl = new JLabel(ConstMessages.Labels.SURNAME);
        JLabel peselLbl = new JLabel(ConstMessages.Labels.PESEL);
        JLabel phoneNumberLbl = new JLabel(ConstMessages.Labels.PHONE_NUMBER);
        JLabel emailLbl = new JLabel(ConstMessages.Labels.EMAIL);

        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        surnameTF = new JTextField(TEXT_FIELD_COLUMNS);
        peselTF = new JTextField(TEXT_FIELD_COLUMNS);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(nameLbl);
        add(nameTF);
        add(surnameLbl);
        add(surnameTF);
        add(peselLbl);
        add(peselTF);
        add(phoneNumberLbl);
        add(phoneNumberTF);
        add(emailLbl);
        add(emailTF);
    }

    public Client getClientFromForm() {
        Client client = new Client();
        client.setName(nameTF.getText());
        client.setSurname(surnameTF.getText());
        client.setPesel(peselTF.getText());
        client.setPhoneNumber(phoneNumberTF.getText());
        client.setEmail(emailTF.getText());
        return client;
    }

    public void clearForm() {
        nameTF.setText("");
        surnameTF.setText("");
        peselTF.setText("");
        phoneNumberTF.setText("");
        emailTF.setText("");
    }

}

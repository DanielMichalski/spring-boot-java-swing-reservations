package com.danielmichalski.reservations.business.ui.forms.client.view.modal;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.business.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.business.ui.forms.client.model.AddressComboBoxModel;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class FormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private final AddressComboBoxModel addressComboBoxModel;

    private JTextField nameTF;
    private JTextField surnameTF;
    private JTextField peselTF;
    private JTextField phoneNumberTF;
    private JTextField emailTF;
    private JComboBox<AddressEntity> addressCB;

    public FormPanel(AddressComboBoxModel addressComboBoxModel) {
        this.addressComboBoxModel = addressComboBoxModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel nameLbl = new JLabel(ConstMessagesEN.Labels.NAME);
        JLabel surnameLbl = new JLabel(ConstMessagesEN.Labels.SURNAME);
        JLabel peselLbl = new JLabel(ConstMessagesEN.Labels.PESEL);
        JLabel phoneNumberLbl = new JLabel(ConstMessagesEN.Labels.PHONE_NUMBER);
        JLabel emailLbl = new JLabel(ConstMessagesEN.Labels.EMAIL);
        JLabel addressLbl = new JLabel(ConstMessagesEN.Labels.ADDRESS);

        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        surnameTF = new JTextField(TEXT_FIELD_COLUMNS);
        peselTF = new JTextField(TEXT_FIELD_COLUMNS);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF = new JTextField(TEXT_FIELD_COLUMNS);
        addressCB = new JComboBox<>(addressComboBoxModel);

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
        add(addressLbl);
        add(addressCB);
    }

    public ClientEntity getClientFromForm() {
        return new ClientEntity(
                addressComboBoxModel.getSelectedItem(),
                nameTF.getText(),
                surnameTF.getText(),
                peselTF.getText(),
                phoneNumberTF.getText(),
                emailTF.getText()
        );
    }

    public void clearForm() {
        nameTF.setText(Strings.EMPTY);
        surnameTF.setText(Strings.EMPTY);
        peselTF.setText(Strings.EMPTY);
        phoneNumberTF.setText(Strings.EMPTY);
        emailTF.setText(Strings.EMPTY);
        addressCB.setSelectedIndex(0);
    }

}

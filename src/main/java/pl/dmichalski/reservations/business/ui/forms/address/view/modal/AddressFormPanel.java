package pl.dmichalski.reservations.business.ui.forms.address.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Address;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddressFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField streetTF;
    private JTextField houseNumberTF;
    private JTextField flatNumberTF;
    private JTextField cityTF;
    private JTextField postalCodeTF;

    public AddressFormPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel streetLbl = new JLabel(ConstMessagesEN.Labels.STREET);
        JLabel houseNumberLbl = new JLabel(ConstMessagesEN.Labels.HOUSE_NUMBER);
        JLabel flatNumberLbl = new JLabel(ConstMessagesEN.Labels.FLAT_NUMBER);
        JLabel cityLbl = new JLabel(ConstMessagesEN.Labels.CITY);
        JLabel postalCodeLbl = new JLabel(ConstMessagesEN.Labels.POSTAL_CODE);

        streetTF = new JTextField(TEXT_FIELD_COLUMNS);
        houseNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        flatNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        cityTF = new JTextField(TEXT_FIELD_COLUMNS);
        postalCodeTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(streetLbl);
        add(streetTF);
        add(houseNumberLbl);
        add(houseNumberTF);
        add(flatNumberLbl);
        add(flatNumberTF);
        add(cityLbl);
        add(cityTF);
        add(postalCodeLbl);
        add(postalCodeTF);
    }

    public Address getEntityFromForm() {
        Address address = new Address();
        address.setStreet(streetTF.getText());
        address.setHouseNumber(houseNumberTF.getText());
        address.setFlatNumber(flatNumberTF.getText());
        address.setCity(cityTF.getText());
        address.setPostCode(postalCodeTF.getText());
        return address;
    }

    public void clearForm() {
        streetTF.setText("");
        houseNumberTF.setText("");
        flatNumberTF.setText("");
        cityTF.setText("");
        postalCodeTF.setText("");
    }

}

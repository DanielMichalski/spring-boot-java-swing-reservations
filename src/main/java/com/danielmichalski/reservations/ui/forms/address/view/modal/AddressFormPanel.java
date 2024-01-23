package com.danielmichalski.reservations.ui.forms.address.view.modal;

import com.danielmichalski.reservations.domain.address.entity.AddressEntity;
import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

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

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        final JLabel streetLbl = new JLabel(ConstMessagesEN.Labels.STREET);
        final JLabel houseNumberLbl = new JLabel(ConstMessagesEN.Labels.HOUSE_NUMBER);
        final JLabel flatNumberLbl = new JLabel(ConstMessagesEN.Labels.FLAT_NUMBER);
        final JLabel cityLbl = new JLabel(ConstMessagesEN.Labels.CITY);
        final JLabel postalCodeLbl = new JLabel(ConstMessagesEN.Labels.POSTAL_CODE);

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

    public AddressEntity getEntityFromForm() {
        return new AddressEntity(
                streetTF.getText(),
                houseNumberTF.getText(),
                flatNumberTF.getText(),
                cityTF.getText(),
                postalCodeTF.getText()
        );
    }

    public void clearForm() {
        streetTF.setText(Strings.EMPTY);
        houseNumberTF.setText(Strings.EMPTY);
        flatNumberTF.setText(Strings.EMPTY);
        cityTF.setText(Strings.EMPTY);
        postalCodeTF.setText(Strings.EMPTY);
    }

}

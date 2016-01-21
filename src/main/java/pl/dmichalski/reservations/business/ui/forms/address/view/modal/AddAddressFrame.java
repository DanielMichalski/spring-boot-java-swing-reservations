package pl.dmichalski.reservations.business.ui.forms.address.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddAddressFrame extends JDialog {

    private AddressFormPanel formPanel;
    private AddressFormBtnPanel formBtnPanel;

    @Autowired
    public AddAddressFrame(AddressFormPanel formPanel, AddressFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ADDRESS_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public AddressFormPanel getFormPanel() {
        return formPanel;
    }

    public AddressFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

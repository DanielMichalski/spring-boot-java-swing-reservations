package pl.dmichalski.reservations.business.ui.client.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessages;

import javax.swing.*;
import java.awt.*;

@Component
public class AddClientFrame extends JDialog {

    private FormPanel formPanel;
    private FormBtnPanel formBtnPanel;

    @Autowired
    public AddClientFrame(FormPanel formPanel, FormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessages.DialogTitles.CLIENT_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public FormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

package pl.dmichalski.reservations.business.ui.forms.rate.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddRateFame extends JDialog {

    private RateFormPanel formPanel;
    private RateFormBtnPanel formBtnPanel;

    @Autowired
    public AddRateFame(RateFormPanel formPanel, RateFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.RATE_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public RateFormPanel getFormPanel() {
        return formPanel;
    }

    public RateFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

package com.danielmichalski.reservations.ui.forms.rate.view.modal;

import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JDialog;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

@Component
@AllArgsConstructor
@Getter
public class AddRateFame extends JDialog {

    private final RateFormPanel formPanel;
    private final RateFormBtnPanel formBtnPanel;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareFrame() {
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

}

package com.danielmichalski.reservations.business.ui.forms.client.view.modal;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
@Getter
public class FormBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    @PostConstruct
    private void initPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

}

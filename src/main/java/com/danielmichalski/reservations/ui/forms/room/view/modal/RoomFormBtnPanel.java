package com.danielmichalski.reservations.ui.forms.room.view.modal;

import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

@Component
@Getter
public class RoomFormBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

}

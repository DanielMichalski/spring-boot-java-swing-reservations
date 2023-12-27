package com.danielmichalski.reservations.ui.forms.roomstatus.view;

import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

@Component
@Getter
public class RoomStatusTableBtnPanel extends JPanel {

    private JButton addBtn;
    private JButton removeBtn;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(addBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);
    }

}

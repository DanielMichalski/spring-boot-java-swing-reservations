package com.danielmichalski.reservations.ui.mainmenu.view;

import com.danielmichalski.reservations.util.border.Borders;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.util.ui.LookAndFeelUtils;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;

@Component
@Getter
public class MainMenuFrame extends JFrame {

    private JButton formsBtn;
    private JButton reportsBtn;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(1, 2, 20, 20));
    }

    private void initComponents() {
        formsBtn = new JButton(ConstMessagesEN.Labels.FORMS);
        reportsBtn = new JButton(ConstMessagesEN.Labels.REPORTS);

        add(formsBtn);
        add(reportsBtn);
    }

}

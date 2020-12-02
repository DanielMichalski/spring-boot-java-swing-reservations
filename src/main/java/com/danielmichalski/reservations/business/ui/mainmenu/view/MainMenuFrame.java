package com.danielmichalski.reservations.business.ui.mainmenu.view;

import java.awt.GridLayout;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.util.border.Borders;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.ui.LookAndFeelUtils;

@Component
@Getter
public class MainMenuFrame extends JFrame {

    private JButton formsBtn;
    private JButton reportsBtn;

    @PostConstruct
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

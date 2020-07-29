package pl.dmichalski.reservations.business.ui.forms.client.view.modal;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JDialog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
@AllArgsConstructor
@Getter
public class AddClientFrame extends JDialog {

    private final FormPanel formPanel;
    private final FormBtnPanel formBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.CLIENT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

}

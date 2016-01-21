package pl.dmichalski.reservations.business.ui.forms.room_type.view.modal;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;

@Component
public class RoomTypeFormBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    public RoomTypeFormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}

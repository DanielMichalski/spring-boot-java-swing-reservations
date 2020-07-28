package pl.dmichalski.reservations.business.ui.forms.room.view.modal;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class AddRoomFrame extends JDialog {

    private RoomFormPanel formPanel;
    private RoomFormBtnPanel formBtnPanel;

    @Autowired
    public AddRoomFrame(RoomFormPanel formPanel, RoomFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ROOM_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public RoomFormPanel getFormPanel() {
        return formPanel;
    }

    public RoomFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

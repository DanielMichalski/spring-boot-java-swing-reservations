package pl.dmichalski.reservations.business.ui.forms.room_status.view.modal;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class AddRoomStatusFrame extends JDialog {

    private RoomStatusFormPanel formPanel;
    private RoomStatusFormBtnPanel formBtnPanel;

    @Autowired
    public AddRoomStatusFrame(RoomStatusFormPanel formPanel, RoomStatusFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ROOM_STATUS_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public RoomStatusFormPanel getFormPanel() {
        return formPanel;
    }

    public RoomStatusFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

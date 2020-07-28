package pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class AddReservationStatusFrame extends JDialog {

    private ReservationStatusFormPanel formPanel;
    private ReservationStatusFormBtnPanel formBtnPanel;

    @Autowired
    public AddReservationStatusFrame(ReservationStatusFormPanel formPanel, ReservationStatusFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ADDRESS_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public ReservationStatusFormPanel getFormPanel() {
        return formPanel;
    }

    public ReservationStatusFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}

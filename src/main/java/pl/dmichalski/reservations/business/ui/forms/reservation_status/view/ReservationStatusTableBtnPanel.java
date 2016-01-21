package pl.dmichalski.reservations.business.ui.forms.reservation_status.view;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;

@Component
public class ReservationStatusTableBtnPanel extends JPanel {

    private JButton addBtn;
    private JButton removeBtn;

    public ReservationStatusTableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(addBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}

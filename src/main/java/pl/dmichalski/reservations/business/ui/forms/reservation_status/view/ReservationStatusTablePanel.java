package pl.dmichalski.reservations.business.ui.forms.reservation_status.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.model.ReservationStatusTableModel;

import javax.swing.*;
import java.awt.*;

@Component
public class ReservationStatusTablePanel extends JPanel {

    private ReservationStatusTableModel tableModel;

    private JTable table;

    @Autowired
    ReservationStatusTablePanel(ReservationStatusTableModel tableModel) {
        this.tableModel = tableModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(table);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

}

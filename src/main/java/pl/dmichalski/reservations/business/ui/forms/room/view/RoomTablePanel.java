package pl.dmichalski.reservations.business.ui.forms.room.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.ui.forms.room.model.RoomTableModel;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomTablePanel extends JPanel {

    private RoomTableModel tableModel;

    private JTable table;

    @Autowired
    RoomTablePanel(RoomTableModel tableModel) {
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

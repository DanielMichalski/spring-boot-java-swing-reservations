package pl.dmichalski.reservations.business.ui.reports.room_statuses.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.model.RoomStatusReportModel;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomStatusReportTablePanel extends JPanel {

    private RoomStatusReportModel tableModel;

    private JTable table;

    @Autowired
    RoomStatusReportTablePanel(RoomStatusReportModel tableModel) {
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

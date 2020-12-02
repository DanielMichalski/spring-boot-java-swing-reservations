package com.danielmichalski.reservations.business.ui.reports.roomstatuses.view;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.ui.reports.roomstatuses.model.RoomStatusReportModel;

@Component
@Getter
public class RoomStatusReportTablePanel extends JPanel {

    private final RoomStatusReportModel tableModel;

    private JTable table;

    RoomStatusReportTablePanel(RoomStatusReportModel tableModel) {
        this.tableModel = tableModel;
    }

    @PostConstruct
    private void preparePanel() {
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

}

package com.danielmichalski.reservations.ui.reports.roomstatuses.view;

import com.danielmichalski.reservations.ui.reports.roomstatuses.model.RoomStatusReportModel;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

@Component
@Getter
public class RoomStatusReportTablePanel extends JPanel {

    private final RoomStatusReportModel tableModel;

    private JTable table;

    RoomStatusReportTablePanel(RoomStatusReportModel tableModel) {
        this.tableModel = tableModel;
    }

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
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

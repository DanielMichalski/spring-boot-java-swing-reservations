package com.danielmichalski.reservations.ui.reports.clientreservations.view;

import com.danielmichalski.reservations.ui.reports.clientreservations.model.ClientReservationsReportModel;
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
public class ClientReservationsReportTablePanel extends JPanel {

    private final ClientReservationsReportModel tableModel;

    private JTable table;

    ClientReservationsReportTablePanel(ClientReservationsReportModel tableModel) {
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

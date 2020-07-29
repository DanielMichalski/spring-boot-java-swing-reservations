package pl.dmichalski.reservations.business.ui.reports.client_reservations.view;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.model.ClientReservationsReportModel;

@Component
@Getter
public class ClientReservationsReportTablePanel extends JPanel {

    private final ClientReservationsReportModel tableModel;

    private JTable table;

    ClientReservationsReportTablePanel(ClientReservationsReportModel tableModel) {
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

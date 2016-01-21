package pl.dmichalski.reservations.business.ui.reports.client_reservations.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class ClientReservationsReportTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private ClientReservationsReportTablePanel tablePanel;

    @Autowired
    public ClientReservationsReportTableFrame(ClientReservationsReportTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.CLIENT_RESERVATIONS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
    }

    public ClientReservationsReportTablePanel getTablePanel() {
        return tablePanel;
    }
}

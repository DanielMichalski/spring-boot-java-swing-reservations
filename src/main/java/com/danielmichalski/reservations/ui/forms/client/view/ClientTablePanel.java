package com.danielmichalski.reservations.ui.forms.client.view;

import com.danielmichalski.reservations.ui.forms.client.model.ClientTableModel;
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
public class ClientTablePanel extends JPanel {

    private final ClientTableModel clientTableModel;

    private JTable clientTable;

    ClientTablePanel(ClientTableModel clientTableModel) {
        this.clientTableModel = clientTableModel;
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
        clientTable = new JTable(clientTableModel);
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(clientTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

}

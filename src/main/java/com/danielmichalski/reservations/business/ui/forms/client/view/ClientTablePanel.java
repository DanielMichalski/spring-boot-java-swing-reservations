package com.danielmichalski.reservations.business.ui.forms.client.view;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.ui.forms.client.model.ClientTableModel;

@Component
@Getter
public class ClientTablePanel extends JPanel {

    private final ClientTableModel clientTableModel;

    private JTable clientTable;

    ClientTablePanel(ClientTableModel clientTableModel) {
        this.clientTableModel = clientTableModel;
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
        clientTable = new JTable(clientTableModel);
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(clientTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

}

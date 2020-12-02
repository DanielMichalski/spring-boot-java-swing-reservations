package com.danielmichalski.reservations.business.ui.forms.rate.view;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RateTableModel;

@Component
@Getter
public class RateTablePanel extends JPanel {

    private final RateTableModel tableModel;

    private JTable table;

    RateTablePanel(RateTableModel tableModel) {
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

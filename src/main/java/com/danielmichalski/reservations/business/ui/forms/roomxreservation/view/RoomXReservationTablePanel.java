package com.danielmichalski.reservations.business.ui.forms.roomxreservation.view;

import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.model.RoomXReservationTableModel;

@Component
@Getter
public class RoomXReservationTablePanel extends JPanel {

    private final RoomXReservationTableModel tableModel;

    private JTable table;

    RoomXReservationTablePanel(RoomXReservationTableModel tableModel) {
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

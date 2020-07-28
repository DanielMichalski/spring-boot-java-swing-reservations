package pl.dmichalski.reservations.business.ui.forms.payment.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.ui.forms.payment.model.PaymentTableModel;

@Component
public class PaymentTablePanel extends JPanel {

    private PaymentTableModel tableModel;

    private JTable table;

    @Autowired
    PaymentTablePanel(PaymentTableModel tableModel) {
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

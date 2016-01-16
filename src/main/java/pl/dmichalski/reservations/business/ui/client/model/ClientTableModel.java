package pl.dmichalski.reservations.business.ui.client.model;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.util.ConstMessages;

import javax.swing.table.AbstractTableModel;
import java.util.List;

@Component
public class ClientTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{ConstMessages.ColumnsLabels.NAME, ConstMessages.ColumnsLabels.SURNAME};
    private List<Client> clients = Lists.newArrayList();

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    public void addClient(Client client) {
        clients.add(client);
        fireTableDataChanged();
    }

    public void addClients(List<Client> clients) {
        this.clients.addAll(clients);
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getSurname();
            default:
                return "";
        }
    }

    public Client getClientByRow(int rowIndex) {
        return clients.get(rowIndex);
    }

    public void removeRow(int row) {
        clients.remove(row);
        fireTableDataChanged();
    }
}

package pl.dmichalski.reservations.business.ui.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.service.ClientService;
import pl.dmichalski.reservations.business.ui.shared.AbstractFrameController;
import pl.dmichalski.reservations.business.ui.client.model.ClientTableModel;
import pl.dmichalski.reservations.business.ui.client.view.TableBtnPanel;
import pl.dmichalski.reservations.business.ui.client.view.ClientFrame;
import pl.dmichalski.reservations.business.util.ConstMessages;

import javax.swing.*;
import java.util.List;

@Controller
public class ClientController extends AbstractFrameController {

    private ClientFrame clientFrame;
    private ClientTableModel clientTableModel;
    private ClientService clientService;

    @Autowired
    public ClientController(ClientFrame clientFrame, ClientTableModel clientTableModel, ClientService clientService) {
        this.clientFrame = clientFrame;
        this.clientTableModel = clientTableModel;
        this.clientService = clientService;
    }

    @Override
    public void prepareAndOpenFrame() {
        prepareListeners();
        loadClients();
        showFrame();
    }

    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = clientFrame.getTableBtnPanel();
        registerAction(tableBtnPanel.getAddBtn(), (e) -> addClient());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
    }

    private void loadClients() {
        List<Client> users = clientService.findAll();
        clientTableModel.addClients(users);
    }

    private void showFrame() {
        clientFrame.setVisible(true);
    }

    private void addClient() {
        //TODO change this below
        Client client = new Client();
        client.setName("name");
        client.setSurname("surname");
        clientService.save(client);
        clientTableModel.addClient(client);
    }

    private void removeClient() {
        JTable clientTable = clientFrame.getTablePanel().getClientTable();
        int selectedRow = clientTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null,
                    ConstMessages.Messages.NON_ROW_SELECTED,
                    ConstMessages.Messages.ALERT_TILE,
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Client client = clientTableModel.getClientByRow(selectedRow);
            clientService.remove(client);
            clientTableModel.removeRow(selectedRow);
        }
    }

}

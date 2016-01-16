package pl.dmichalski.reservations.business.ui.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.service.ClientService;
import pl.dmichalski.reservations.business.ui.client.view.modal.AddClientFrame;
import pl.dmichalski.reservations.business.ui.client.view.modal.FormBtnPanel;
import pl.dmichalski.reservations.business.ui.client.view.modal.FormPanel;
import pl.dmichalski.reservations.business.ui.shared.AbstractFrameController;
import pl.dmichalski.reservations.business.ui.client.model.ClientTableModel;
import pl.dmichalski.reservations.business.ui.client.view.TableBtnPanel;
import pl.dmichalski.reservations.business.ui.client.view.ClientFrame;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.ClientValidator;

import javax.swing.*;
import java.util.List;

@Controller
public class ClientController extends AbstractFrameController {

    private ClientFrame clientFrame;
    private AddClientFrame addClientFrame;
    private ClientTableModel clientTableModel;
    private ClientService clientService;
    private ClientValidator clientValidator;

    @Autowired
    public ClientController(ClientFrame clientFrame,
                            AddClientFrame addClientFrame,
                            ClientTableModel clientTableModel,
                            ClientService clientService,
                            ClientValidator clientValidator) {
        this.clientFrame = clientFrame;
        this.addClientFrame = addClientFrame;
        this.clientTableModel = clientTableModel;
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @Override
    public void prepareAndOpenFrame() {
        prepareListeners();
        loadClients();
        showClientsFrame();
    }

    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = clientFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addClientFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClientModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    private void loadClients() {
        List<Client> users = clientService.findAll();
        clientTableModel.addClients(users);
    }

    private void showClientsFrame() {
        clientFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addClientFrame.setVisible(true);
    }

    private void saveClient() {
        FormPanel formPanel = addClientFrame.getFormPanel();
        Client client = formPanel.getClientFromForm();
        if (clientValidator.isValid(client)) {
            clientService.save(client);
            clientTableModel.addClient(client);
            closeModalWindow();
        } else {
            Notifications.showFormValidationAlert();
        }
    }

    private void closeModalWindow() {
        addClientFrame.getFormPanel().clearForm();
        addClientFrame.dispose();
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

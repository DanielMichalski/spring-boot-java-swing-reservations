package com.danielmichalski.reservations.ui.forms.client.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.address.entity.AddressEntity;
import com.danielmichalski.reservations.domain.address.service.AddressService;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import com.danielmichalski.reservations.domain.client.service.ClientService;
import com.danielmichalski.reservations.domain.client.validation.ClientValidator;
import com.danielmichalski.reservations.ui.forms.client.model.AddressComboBoxModel;
import com.danielmichalski.reservations.ui.forms.client.model.ClientTableModel;
import com.danielmichalski.reservations.ui.forms.client.view.ClientFrame;
import com.danielmichalski.reservations.ui.forms.client.view.TableBtnPanel;
import com.danielmichalski.reservations.ui.forms.client.view.modal.AddClientFrame;
import com.danielmichalski.reservations.ui.forms.client.view.modal.FormBtnPanel;
import com.danielmichalski.reservations.ui.forms.client.view.modal.FormPanel;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.util.notification.Notifications;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ClientController extends AbstractFrameController {

    private final ClientFrame clientFrame;
    private final AddClientFrame addClientFrame;
    private final ClientTableModel clientTableModel;
    private final ClientService clientService;
    private final ClientValidator clientValidator;
    private final AddressService addressService;
    private final AddressComboBoxModel addressComboBoxModel;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = clientFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addClientFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClientModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadClients();
        loadAddresses();
        showClientsFrame();
    }

    private void loadClients() {
        List<ClientEntity> users = clientService.findAll();
        clientTableModel.clear();
        clientTableModel.addEntities(users);
    }

    private void loadAddresses() {
        List<AddressEntity> addresses = addressService.findAll();
        addressComboBoxModel.clear();
        addressComboBoxModel.addElements(addresses);
    }

    private void showClientsFrame() {
        clientFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addClientFrame.setVisible(true);
    }

    private void saveClient() {
        FormPanel formPanel = addClientFrame.getFormPanel();
        ClientEntity client = formPanel.getClientFromForm();
        Optional<ValidationError> errors = clientValidator.validate(client);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
        } else {
            clientService.save(client);
            clientTableModel.addEntity(client);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addClientFrame.getFormPanel().clearForm();
        addClientFrame.dispose();
    }

    private void removeClient() {
        try {
            JTable clientTable = clientFrame.getClientTablePanel().getClientTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                ClientEntity client = clientTableModel.getEntityByRow(selectedRow);
                clientService.remove(client);
                clientTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

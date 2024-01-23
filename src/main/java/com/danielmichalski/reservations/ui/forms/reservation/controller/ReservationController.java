package com.danielmichalski.reservations.ui.forms.reservation.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import com.danielmichalski.reservations.domain.client.service.ClientService;
import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.domain.payment.service.PaymentService;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.domain.reservation.service.ReservationService;
import com.danielmichalski.reservations.domain.reservation.service.ReservationStatusService;
import com.danielmichalski.reservations.domain.reservation.validation.ReservationValidator;
import com.danielmichalski.reservations.ui.forms.reservation.model.ClientComboBoxModel;
import com.danielmichalski.reservations.ui.forms.reservation.model.PaymentComboBoxModel;
import com.danielmichalski.reservations.ui.forms.reservation.model.ReservationStatusComboBoxModel;
import com.danielmichalski.reservations.ui.forms.reservation.model.ReservationTableModel;
import com.danielmichalski.reservations.ui.forms.reservation.view.ReservationTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.reservation.view.ReservationTableFrame;
import com.danielmichalski.reservations.ui.forms.reservation.view.modal.AddReservationFrame;
import com.danielmichalski.reservations.ui.forms.reservation.view.modal.ReservationFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.reservation.view.modal.ReservationFormPanel;
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
public class ReservationController extends AbstractFrameController {

    private final ReservationTableFrame tableFrame;
    private final AddReservationFrame addFrame;
    private final ReservationTableModel tableModel;
    private final ReservationService reservationService;
    private final ReservationValidator validator;
    private final ReservationStatusService reservationStatusService;
    private final PaymentService paymentService;
    private final ClientService clientService;
    private final ReservationStatusComboBoxModel reservationStatusComboBoxModel;
    private final PaymentComboBoxModel paymentComboBoxModel;
    private final ClientComboBoxModel clientComboBoxModel;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareListeners() {
        ReservationTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        ReservationFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadReservationStatuses();
        loadPayments();
        loadClients();
        showTableFrame();
    }

    private void loadEntities() {
        List<ReservationEntity> entities = reservationService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadReservationStatuses() {
        List<ReservationStatusEntity> reservationStatuses = reservationStatusService.findAll();
        reservationStatusComboBoxModel.clear();
        reservationStatusComboBoxModel.addElements(reservationStatuses);
    }

    private void loadPayments() {
        List<PaymentEntity> payments = paymentService.findAll();
        paymentComboBoxModel.clear();
        paymentComboBoxModel.addElements(payments);
    }

    private void loadClients() {
        List<ClientEntity> clients = clientService.findAll();
        clientComboBoxModel.clear();
        clientComboBoxModel.addElements(clients);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        ReservationFormPanel formPanel = addFrame.getFormPanel();
        ReservationEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
        } else {
            reservationService.save(entity);
            tableModel.addEntity(entity);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addFrame.getFormPanel().clearForm();
        addFrame.dispose();
    }

    private void removeEntity() {
        try {
            JTable table = tableFrame.getTablePanel().getTable();
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                ReservationEntity entity = tableModel.getEntityByRow(selectedRow);
                reservationService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

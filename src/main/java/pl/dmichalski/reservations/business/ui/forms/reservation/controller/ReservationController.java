package pl.dmichalski.reservations.business.ui.forms.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.entity.Payment;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.service.ClientService;
import pl.dmichalski.reservations.business.service.PaymentService;
import pl.dmichalski.reservations.business.service.ReservationService;
import pl.dmichalski.reservations.business.service.ReservationStatusService;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.ClientComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.PaymentComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.ReservationStatusComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.model.ReservationTableModel;
import pl.dmichalski.reservations.business.ui.forms.reservation.view.ReservationTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation.view.ReservationTableFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation.view.modal.AddReservationFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation.view.modal.ReservationFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation.view.modal.ReservationFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.ReservationValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController extends AbstractFrameController {

    private ReservationTableFrame tableFrame;
    private AddReservationFrame addFrame;
    private ReservationTableModel tableModel;
    private ReservationService reservationService;
    private ReservationValidator validator;
    private ReservationStatusService reservationStatusService;
    private PaymentService paymentService;
    private ClientService clientService;
    private ReservationStatusComboBoxModel reservationStatusComboBoxModel;
    private PaymentComboBoxModel paymentComboBoxModel;
    private ClientComboBoxModel clientComboBoxModel;

    @Autowired
    public ReservationController(ReservationTableFrame tableFrame,
                                 AddReservationFrame addFrame,
                                 ReservationTableModel tableModel,
                                 ReservationService reservationService,
                                 ReservationValidator validator,
                                 ReservationStatusService reservationStatusService,
                                 PaymentService paymentService,
                                 ClientService clientService,
                                 ReservationStatusComboBoxModel reservationStatusComboBoxModel,
                                 PaymentComboBoxModel paymentComboBoxModel,
                                 ClientComboBoxModel clientComboBoxModel) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.reservationService = reservationService;
        this.validator = validator;
        this.reservationStatusService = reservationStatusService;
        this.paymentService = paymentService;
        this.clientService = clientService;
        this.reservationStatusComboBoxModel = reservationStatusComboBoxModel;
        this.paymentComboBoxModel = paymentComboBoxModel;
        this.clientComboBoxModel = clientComboBoxModel;
    }

    @PostConstruct
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
        List<Reservation> entities = reservationService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadReservationStatuses() {
        List<ReservationStatus> reservationStatuses = reservationStatusService.findAll();
        reservationStatusComboBoxModel.clear();
        reservationStatusComboBoxModel.addElements(reservationStatuses);
    }

    private void loadPayments() {
        List<Payment> payments = paymentService.findAll();
        paymentComboBoxModel.clear();
        paymentComboBoxModel.addElements(payments);
    }

    private void loadClients() {
        List<Client> clients = clientService.findAll();
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
        Reservation entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
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
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Reservation entity = tableModel.getEntityByRow(selectedRow);
                reservationService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

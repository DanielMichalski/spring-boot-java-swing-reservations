package pl.dmichalski.reservations.business.ui.forms.reservation_status.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.ReservationStatus;
import pl.dmichalski.reservations.business.service.ReservationStatusService;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.model.ReservationStatusTableModel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.ReservationStatusTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.ReservationStatusTableFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.AddReservationStatusFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.ReservationStatusFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.ReservationStatusFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.ReservationStatusValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationStatusController extends AbstractFrameController {

    private ReservationStatusTableFrame tableFrame;
    private AddReservationStatusFrame addFrame;
    private ReservationStatusTableModel tableModel;
    private ReservationStatusService reservationStatusService;
    private ReservationStatusValidator validator;

    @Autowired
    public ReservationStatusController(ReservationStatusTableFrame tableFrame,
                                       AddReservationStatusFrame addFrame,
                                       ReservationStatusTableModel tableModel,
                                       ReservationStatusService reservationStatusService,
                                       ReservationStatusValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.reservationStatusService = reservationStatusService;
        this.validator = validator;
    }

    @PostConstruct
    private void prepareListeners() {
        ReservationStatusTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        ReservationStatusFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        List<ReservationStatus> entities = reservationStatusService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        ReservationStatusFormPanel formPanel = addFrame.getFormPanel();
        ReservationStatus entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            reservationStatusService.save(entity);
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
                ReservationStatus entity = tableModel.getEntityByRow(selectedRow);
                reservationStatusService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

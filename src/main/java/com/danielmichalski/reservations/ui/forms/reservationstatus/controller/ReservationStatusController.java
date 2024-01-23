package com.danielmichalski.reservations.ui.forms.reservationstatus.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.domain.reservation.service.ReservationStatusService;
import com.danielmichalski.reservations.domain.reservation.validation.ReservationStatusValidator;
import com.danielmichalski.reservations.ui.forms.reservationstatus.model.ReservationStatusTableModel;
import com.danielmichalski.reservations.ui.forms.reservationstatus.view.ReservationStatusTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.reservationstatus.view.ReservationStatusTableFrame;
import com.danielmichalski.reservations.ui.forms.reservationstatus.view.modal.AddReservationStatusFrame;
import com.danielmichalski.reservations.ui.forms.reservationstatus.view.modal.ReservationStatusFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.reservationstatus.view.modal.ReservationStatusFormPanel;
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
public class ReservationStatusController extends AbstractFrameController {

    private final ReservationStatusTableFrame tableFrame;
    private final AddReservationStatusFrame addFrame;
    private final ReservationStatusTableModel tableModel;
    private final ReservationStatusService reservationStatusService;
    private final ReservationStatusValidator validator;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
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
        List<ReservationStatusEntity> entities = reservationStatusService.findAll();
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
        ReservationStatusEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
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
                JOptionPane.showMessageDialog(
                        null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                ReservationStatusEntity entity = tableModel.getEntityByRow(selectedRow);
                reservationStatusService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

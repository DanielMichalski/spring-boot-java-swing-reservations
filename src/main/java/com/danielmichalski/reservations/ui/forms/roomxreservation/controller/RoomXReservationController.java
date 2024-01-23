package com.danielmichalski.reservations.ui.forms.roomxreservation.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.domain.reservation.service.ReservationService;
import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import com.danielmichalski.reservations.domain.room.service.RoomService;
import com.danielmichalski.reservations.domain.room.service.RoomXReservationService;
import com.danielmichalski.reservations.domain.room.validation.RoomXReservationValidator;
import com.danielmichalski.reservations.ui.forms.rate.model.RoomComboBoxModel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.model.ReservationsComboBoxModel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.model.RoomXReservationTableModel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.view.RoomXReservationTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.view.RoomXReservationTableFrame;
import com.danielmichalski.reservations.ui.forms.roomxreservation.view.modal.AddRoomXReservationFame;
import com.danielmichalski.reservations.ui.forms.roomxreservation.view.modal.RoomXReservationFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.roomxreservation.view.modal.RoomXReservationFormPanel;
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
public class RoomXReservationController extends AbstractFrameController {

    private final RoomXReservationTableFrame tableFrame;
    private final AddRoomXReservationFame addFrame;
    private final RoomXReservationTableModel tableModel;
    private final RoomXReservationService roomXReservationService;
    private final ReservationService reservationService;
    private final RoomService roomService;
    private final ReservationsComboBoxModel reservationsComboBoxModel;
    private final RoomComboBoxModel roomComboBoxModel;
    private final RoomXReservationValidator validator;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareListeners() {
        RoomXReservationTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RoomXReservationFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadReservations();
        loadRooms();
        showTableFrame();
    }

    private void loadEntities() {
        List<RoomXReservationEntity> entities = roomXReservationService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadRooms() {
        List<RoomEntity> entities = roomService.findAll();
        roomComboBoxModel.clear();
        roomComboBoxModel.addElements(entities);
    }

    private void loadReservations() {
        List<ReservationEntity> entities = reservationService.findAll();
        reservationsComboBoxModel.clear();
        reservationsComboBoxModel.addElements(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        RoomXReservationFormPanel formPanel = addFrame.getFormPanel();
        RoomXReservationEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
        } else {
            roomXReservationService.save(entity);
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
                RoomXReservationEntity entity = tableModel.getEntityByRow(selectedRow);
                roomXReservationService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

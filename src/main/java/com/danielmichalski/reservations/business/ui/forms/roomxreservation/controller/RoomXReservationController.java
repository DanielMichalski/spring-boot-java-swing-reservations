package com.danielmichalski.reservations.business.ui.forms.roomxreservation.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.reservation.ReservationService;
import com.danielmichalski.reservations.business.app.service.room.RoomService;
import com.danielmichalski.reservations.business.app.service.room.RoomXReservationService;
import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.model.ReservationsComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.model.RoomXReservationTableModel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.RoomXReservationTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.RoomXReservationTableFrame;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.modal.AddRoomXReservationFame;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.modal.RoomXReservationFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.view.modal.RoomXReservationFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.room.RoomXReservationValidator;

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
            Notifications.showFormValidationAlert(validationError.getMessage());
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
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
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

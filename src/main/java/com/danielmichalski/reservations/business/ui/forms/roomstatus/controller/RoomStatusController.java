package com.danielmichalski.reservations.business.ui.forms.roomstatus.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.room.RoomStatusService;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.model.RoomStatusTableModel;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.view.RoomStatusTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.view.RoomStatusTableFrame;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.view.modal.AddRoomStatusFrame;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.view.modal.RoomStatusFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.view.modal.RoomStatusFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.room.RoomStatusValidator;

@Controller
@AllArgsConstructor
public class RoomStatusController extends AbstractFrameController {

    private final RoomStatusTableFrame tableFrame;
    private final AddRoomStatusFrame addFrame;
    private final RoomStatusTableModel tableModel;
    private final RoomStatusService roomStatusService;
    private final RoomStatusValidator validator;

    @PostConstruct
    private void prepareListeners() {
        RoomStatusTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RoomStatusFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<RoomStatusEntity> entities = roomStatusService.findAll();
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
        RoomStatusFormPanel formPanel = addFrame.getFormPanel();
        RoomStatusEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            roomStatusService.save(entity);
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
                RoomStatusEntity entity = tableModel.getEntityByRow(selectedRow);
                roomStatusService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

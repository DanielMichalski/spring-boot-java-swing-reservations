package com.danielmichalski.reservations.ui.forms.roomtype.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.room.entity.RoomTypeEntity;
import com.danielmichalski.reservations.domain.room.service.RoomTypeService;
import com.danielmichalski.reservations.domain.room.validation.RoomTypeValidator;
import com.danielmichalski.reservations.ui.forms.roomtype.model.RoomTypeTableModel;
import com.danielmichalski.reservations.ui.forms.roomtype.view.RoomTypeTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.roomtype.view.RoomTypeTableFrame;
import com.danielmichalski.reservations.ui.forms.roomtype.view.modal.AddRoomTypeFrame;
import com.danielmichalski.reservations.ui.forms.roomtype.view.modal.RoomTypeFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.roomtype.view.modal.RoomTypeFormPanel;
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
public class RoomTypeController extends AbstractFrameController {

    private final RoomTypeTableFrame tableFrame;
    private final AddRoomTypeFrame addFrame;
    private final RoomTypeTableModel tableModel;
    private final RoomTypeService roomTypeService;
    private final RoomTypeValidator validator;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void prepareListeners() {
        RoomTypeTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RoomTypeFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<RoomTypeEntity> entities = roomTypeService.findAll();
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
        RoomTypeFormPanel formPanel = addFrame.getFormPanel();
        RoomTypeEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
        } else {
            roomTypeService.save(entity);
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
                RoomTypeEntity entity = tableModel.getEntityByRow(selectedRow);
                roomTypeService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

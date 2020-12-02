package com.danielmichalski.reservations.business.ui.forms.roomtype.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.room.RoomTypeService;
import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.ui.forms.roomtype.model.RoomTypeTableModel;
import com.danielmichalski.reservations.business.ui.forms.roomtype.view.RoomTypeTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomtype.view.RoomTypeTableFrame;
import com.danielmichalski.reservations.business.ui.forms.roomtype.view.modal.AddRoomTypeFrame;
import com.danielmichalski.reservations.business.ui.forms.roomtype.view.modal.RoomTypeFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.roomtype.view.modal.RoomTypeFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.room.RoomTypeValidator;

@Controller
@AllArgsConstructor
public class RoomTypeController extends AbstractFrameController {

    private final RoomTypeTableFrame tableFrame;
    private final AddRoomTypeFrame addFrame;
    private final RoomTypeTableModel tableModel;
    private final RoomTypeService roomTypeService;
    private final RoomTypeValidator validator;

    @PostConstruct
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
            Notifications.showFormValidationAlert(validationError.getMessage());
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
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
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

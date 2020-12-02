package com.danielmichalski.reservations.business.ui.forms.room.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.room.RoomService;
import com.danielmichalski.reservations.business.app.service.room.RoomStatusService;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.ui.forms.room.model.RoomStatusComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.room.model.RoomTableModel;
import com.danielmichalski.reservations.business.ui.forms.room.view.RoomTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.room.view.RoomTableFrame;
import com.danielmichalski.reservations.business.ui.forms.room.view.modal.AddRoomFrame;
import com.danielmichalski.reservations.business.ui.forms.room.view.modal.RoomFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.room.view.modal.RoomFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.room.RoomValidator;

@Controller
@AllArgsConstructor
public class RoomController extends AbstractFrameController {

    private final RoomTableFrame tableFrame;
    private final AddRoomFrame addFrame;
    private final RoomTableModel tableModel;
    private final RoomService roomService;
    private final RoomStatusService roomStatusService;
    private final RoomStatusComboBoxModel roomStatusComboBoxModel;
    private final RoomValidator validator;

    @PostConstruct
    private void prepareListeners() {
        RoomTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RoomFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadPaymentMethods();
        showTableFrame();
    }

    private void loadEntities() {
        List<RoomEntity> entities = roomService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadPaymentMethods() {
        List<RoomStatusEntity> entities = roomStatusService.findAll();
        roomStatusComboBoxModel.clear();
        roomStatusComboBoxModel.addElements(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        RoomFormPanel formPanel = addFrame.getFormPanel();
        RoomEntity room = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(room);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            roomService.save(room);
            tableModel.addEntity(room);
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
                RoomEntity entity = tableModel.getEntityByRow(selectedRow);
                roomService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

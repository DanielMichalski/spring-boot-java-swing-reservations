package com.danielmichalski.reservations.business.ui.forms.rate.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.rate.RateService;
import com.danielmichalski.reservations.business.app.service.room.RoomService;
import com.danielmichalski.reservations.business.app.service.room.RoomTypeService;
import com.danielmichalski.reservations.business.domain.entity.rate.RateEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RateTableModel;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.rate.model.RoomTypeComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.rate.view.RateTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.rate.view.RateTableFrame;
import com.danielmichalski.reservations.business.ui.forms.rate.view.modal.AddRateFame;
import com.danielmichalski.reservations.business.ui.forms.rate.view.modal.RateFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.rate.view.modal.RateFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.rate.RateValidator;

@Controller
@AllArgsConstructor
public class RateController extends AbstractFrameController {

    private final RateTableFrame tableFrame;
    private final AddRateFame addFrame;
    private final RateTableModel tableModel;
    private final RateService rateService;
    private final RoomService roomService;
    private final RoomComboBoxModel roomComboBoxModel;
    private final RoomTypeService roomTypeService;
    private final RoomTypeComboBoxModel roomTypeComboBoxModel;
    private final RateValidator validator;

    @PostConstruct
    private void prepareListeners() {
        RateTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RateFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadRooms();
        loadRoomsTypes();
        showTableFrame();
    }

    private void loadEntities() {
        List<RateEntity> entities = rateService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadRooms() {
        List<RoomEntity> entities = roomService.findAll();
        roomComboBoxModel.clear();
        roomComboBoxModel.addElements(entities);
    }

    private void loadRoomsTypes() {
        List<RoomTypeEntity> entities = roomTypeService.findAll();
        roomTypeComboBoxModel.clear();
        roomTypeComboBoxModel.addElements(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        RateFormPanel formPanel = addFrame.getFormPanel();
        RateEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            rateService.save(entity);
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
                RateEntity entity = tableModel.getEntityByRow(selectedRow);
                rateService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

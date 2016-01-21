package pl.dmichalski.reservations.business.ui.forms.room_type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.service.RoomTypeService;
import pl.dmichalski.reservations.business.ui.forms.room_type.model.RoomTypeTableModel;
import pl.dmichalski.reservations.business.ui.forms.room_type.view.RoomTypeTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_type.view.RoomTypeTableFrame;
import pl.dmichalski.reservations.business.ui.forms.room_type.view.modal.AddRoomTypeFrame;
import pl.dmichalski.reservations.business.ui.forms.room_type.view.modal.RoomTypeFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_type.view.modal.RoomTypeFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.RoomTypeValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class RoomTypeController extends AbstractFrameController {

    private RoomTypeTableFrame tableFrame;
    private AddRoomTypeFrame addFrame;
    private RoomTypeTableModel tableModel;
    private RoomTypeService roomTypeService;
    private RoomTypeValidator validator;

    @Autowired
    public RoomTypeController(RoomTypeTableFrame tableFrame,
                              AddRoomTypeFrame addFrame,
                              RoomTypeTableModel tableModel,
                              RoomTypeService roomTypeService,
                              RoomTypeValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.roomTypeService = roomTypeService;
        this.validator = validator;
    }

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
        List<RoomType> entities = roomTypeService.findAll();
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
        RoomType entity = formPanel.getEntityFromForm();
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
                RoomType entity = tableModel.getEntityByRow(selectedRow);
                roomTypeService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

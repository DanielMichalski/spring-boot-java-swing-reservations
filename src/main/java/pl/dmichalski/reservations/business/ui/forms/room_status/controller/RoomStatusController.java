package pl.dmichalski.reservations.business.ui.forms.room_status.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.service.RoomStatusService;
import pl.dmichalski.reservations.business.ui.forms.room_status.model.RoomStatusTableModel;
import pl.dmichalski.reservations.business.ui.forms.room_status.view.RoomStatusTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_status.view.RoomStatusTableFrame;
import pl.dmichalski.reservations.business.ui.forms.room_status.view.modal.AddRoomStatusFrame;
import pl.dmichalski.reservations.business.ui.forms.room_status.view.modal.RoomStatusFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_status.view.modal.RoomStatusFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.RoomStatusValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class RoomStatusController extends AbstractFrameController {

    private RoomStatusTableFrame tableFrame;
    private AddRoomStatusFrame addFrame;
    private RoomStatusTableModel tableModel;
    private RoomStatusService roomStatusService;
    private RoomStatusValidator validator;

    @Autowired
    public RoomStatusController(RoomStatusTableFrame tableFrame,
                                AddRoomStatusFrame addFrame,
                                RoomStatusTableModel tableModel,
                                RoomStatusService roomStatusService,
                                RoomStatusValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.roomStatusService = roomStatusService;
        this.validator = validator;
    }

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
        List<RoomStatus> entities = roomStatusService.findAll();
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
        RoomStatus entity = formPanel.getEntityFromForm();
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
                RoomStatus entity = tableModel.getEntityByRow(selectedRow);
                roomStatusService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

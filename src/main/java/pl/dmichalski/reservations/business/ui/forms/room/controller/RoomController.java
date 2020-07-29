package pl.dmichalski.reservations.business.ui.forms.room.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.app.service.room.RoomService;
import pl.dmichalski.reservations.business.app.service.room.RoomStatusService;
import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.ui.forms.room.model.RoomStatusComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.room.model.RoomTableModel;
import pl.dmichalski.reservations.business.ui.forms.room.view.RoomTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room.view.RoomTableFrame;
import pl.dmichalski.reservations.business.ui.forms.room.view.modal.AddRoomFrame;
import pl.dmichalski.reservations.business.ui.forms.room.view.modal.RoomFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room.view.modal.RoomFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.notification.Notifications;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.room.RoomValidator;

@Controller
public class RoomController extends AbstractFrameController {

    private RoomTableFrame tableFrame;
    private AddRoomFrame addFrame;
    private RoomTableModel tableModel;
    private RoomService roomService;
    private RoomStatusService roomStatusService;
    private RoomStatusComboBoxModel roomStatusComboBoxModel;
    private RoomValidator validator;

    @Autowired
    public RoomController(RoomTableFrame tableFrame,
                          AddRoomFrame addFrame,
                          RoomTableModel tableModel,
                          RoomService roomService,
                          RoomStatusService roomStatusService,
                          RoomStatusComboBoxModel roomStatusComboBoxModel,
                          RoomValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.roomService = roomService;
        this.roomStatusService = roomStatusService;
        this.roomStatusComboBoxModel = roomStatusComboBoxModel;
        this.validator = validator;
    }

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

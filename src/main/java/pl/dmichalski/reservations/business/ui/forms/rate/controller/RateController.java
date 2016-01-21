package pl.dmichalski.reservations.business.ui.forms.rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.service.RateService;
import pl.dmichalski.reservations.business.service.RoomService;
import pl.dmichalski.reservations.business.service.RoomTypeService;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RateTableModel;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomTypeComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.rate.view.RateTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.rate.view.RateTableFrame;
import pl.dmichalski.reservations.business.ui.forms.rate.view.modal.AddRateFame;
import pl.dmichalski.reservations.business.ui.forms.rate.view.modal.RateFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.rate.view.modal.RateFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.RateValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class RateController extends AbstractFrameController {

    private RateTableFrame tableFrame;
    private AddRateFame addFrame;
    private RateTableModel tableModel;
    private RateService rateService;
    private RoomService roomService;
    private RoomComboBoxModel roomComboBoxModel;
    private RoomTypeService roomTypeService;
    private RoomTypeComboBoxModel roomTypeComboBoxModel;
    private RateValidator validator;

    @Autowired
    public RateController(RateTableFrame tableFrame,
                          AddRateFame addFrame,
                          RateTableModel tableModel,
                          RateService rateService,
                          RoomService roomService,
                          RoomComboBoxModel roomComboBoxModel,
                          RoomTypeService roomTypeService,
                          RoomTypeComboBoxModel roomTypeComboBoxModel,
                          RateValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.rateService = rateService;
        this.roomService = roomService;
        this.roomComboBoxModel = roomComboBoxModel;
        this.roomTypeService = roomTypeService;
        this.roomTypeComboBoxModel = roomTypeComboBoxModel;
        this.validator = validator;
    }

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
        List<Rate> entities = rateService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadRooms() {
        List<Room> entities = roomService.findAll();
        roomComboBoxModel.clear();
        roomComboBoxModel.addElements(entities);
    }

    private void loadRoomsTypes() {
        List<RoomType> entities = roomTypeService.findAll();
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
        Rate entity = formPanel.getEntityFromForm();
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
                Rate entity = tableModel.getEntityByRow(selectedRow);
                rateService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

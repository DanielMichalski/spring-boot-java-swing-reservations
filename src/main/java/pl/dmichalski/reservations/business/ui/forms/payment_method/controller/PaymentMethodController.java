package pl.dmichalski.reservations.business.ui.forms.payment_method.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.service.PaymentMethodService;
import pl.dmichalski.reservations.business.ui.forms.payment_method.model.PaymentMethodTableModel;
import pl.dmichalski.reservations.business.ui.forms.payment_method.view.PaymentMethodTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.payment_method.view.PaymentMethodTableFrame;
import pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal.AddPaymentMethodFrame;
import pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal.PaymentMethodFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.payment_method.view.modal.PaymentMethodFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.PaymentMethodValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class PaymentMethodController extends AbstractFrameController {

    private PaymentMethodTableFrame tableFrame;
    private AddPaymentMethodFrame addFrame;
    private PaymentMethodTableModel tableModel;
    private PaymentMethodService paymentMethodService;
    private PaymentMethodValidator validator;

    @Autowired
    public PaymentMethodController(PaymentMethodTableFrame tableFrame,
                                   AddPaymentMethodFrame addFrame,
                                   PaymentMethodTableModel tableModel,
                                   PaymentMethodService paymentMethodService,
                                   PaymentMethodValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.paymentMethodService = paymentMethodService;
        this.validator = validator;
    }

    @PostConstruct
    private void prepareListeners() {
        PaymentMethodTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        PaymentMethodFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<PaymentMethod> entities = paymentMethodService.findAll();
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
        PaymentMethodFormPanel formPanel = addFrame.getFormPanel();
        PaymentMethod entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            paymentMethodService.save(entity);
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
                PaymentMethod entity = tableModel.getEntityByRow(selectedRow);
                paymentMethodService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

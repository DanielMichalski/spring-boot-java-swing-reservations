package pl.dmichalski.reservations.business.ui.forms.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.Payment;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.service.PaymentMethodService;
import pl.dmichalski.reservations.business.service.PaymentService;
import pl.dmichalski.reservations.business.ui.forms.payment.model.PaymentMethodComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.payment.model.PaymentTableModel;
import pl.dmichalski.reservations.business.ui.forms.payment.view.PaymentTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.payment.view.PaymentTableFrame;
import pl.dmichalski.reservations.business.ui.forms.payment.view.modal.AddPaymentFrame;
import pl.dmichalski.reservations.business.ui.forms.payment.view.modal.PaymentFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.payment.view.modal.PaymentFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.PaymentValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class PaymentController extends AbstractFrameController {

    private PaymentTableFrame tableFrame;
    private AddPaymentFrame addFrame;
    private PaymentTableModel tableModel;
    private PaymentService paymentService;
    private PaymentMethodService paymentMethodService;
    private PaymentMethodComboBoxModel paymentMethodComboBoxModel;
    private PaymentValidator validator;

    @Autowired
    public PaymentController(PaymentTableFrame tableFrame,
                             AddPaymentFrame addFrame,
                             PaymentTableModel tableModel,
                             PaymentService paymentService,
                             PaymentMethodService paymentMethodService,
                             PaymentMethodComboBoxModel paymentMethodComboBoxModel,
                             PaymentValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.paymentService = paymentService;
        this.paymentMethodService = paymentMethodService;
        this.paymentMethodComboBoxModel = paymentMethodComboBoxModel;
        this.validator = validator;
    }

    @PostConstruct
    private void prepareListeners() {
        PaymentTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        PaymentFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<Payment> entities = paymentService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.findAll();
        paymentMethodComboBoxModel.clear();
        paymentMethodComboBoxModel.addElements(paymentMethods);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        PaymentFormPanel formPanel = addFrame.getFormPanel();
        Payment entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            paymentService.save(entity);
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
                Payment entity = tableModel.getEntityByRow(selectedRow);
                paymentService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

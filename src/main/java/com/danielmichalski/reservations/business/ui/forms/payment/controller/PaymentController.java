package com.danielmichalski.reservations.business.ui.forms.payment.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.payment.PaymentMethodService;
import com.danielmichalski.reservations.business.app.service.payment.PaymentService;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import com.danielmichalski.reservations.business.ui.forms.payment.model.PaymentMethodComboBoxModel;
import com.danielmichalski.reservations.business.ui.forms.payment.model.PaymentTableModel;
import com.danielmichalski.reservations.business.ui.forms.payment.view.PaymentTableBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.payment.view.PaymentTableFrame;
import com.danielmichalski.reservations.business.ui.forms.payment.view.modal.AddPaymentFrame;
import com.danielmichalski.reservations.business.ui.forms.payment.view.modal.PaymentFormBtnPanel;
import com.danielmichalski.reservations.business.ui.forms.payment.view.modal.PaymentFormPanel;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.business.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.business.util.notification.Notifications;
import com.danielmichalski.reservations.business.validation.ValidationError;
import com.danielmichalski.reservations.business.validation.payment.PaymentValidator;

@Controller
@AllArgsConstructor
public class PaymentController extends AbstractFrameController {

    private final PaymentTableFrame tableFrame;
    private final AddPaymentFrame addFrame;
    private final PaymentTableModel tableModel;
    private final PaymentService paymentService;
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodComboBoxModel paymentMethodComboBoxModel;
    private final PaymentValidator validator;

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
        List<PaymentEntity> entities = paymentService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadPaymentMethods() {
        List<PaymentMethodEntity> paymentMethods = paymentMethodService.findAll();
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
        PaymentEntity entity = formPanel.getEntityFromForm();
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
                PaymentEntity entity = tableModel.getEntityByRow(selectedRow);
                paymentService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

package com.danielmichalski.reservations.ui.forms.payment.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import com.danielmichalski.reservations.domain.payment.service.PaymentMethodService;
import com.danielmichalski.reservations.domain.payment.service.PaymentService;
import com.danielmichalski.reservations.domain.payment.validation.PaymentValidator;
import com.danielmichalski.reservations.ui.forms.payment.model.PaymentMethodComboBoxModel;
import com.danielmichalski.reservations.ui.forms.payment.model.PaymentTableModel;
import com.danielmichalski.reservations.ui.forms.payment.view.PaymentTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.payment.view.PaymentTableFrame;
import com.danielmichalski.reservations.ui.forms.payment.view.modal.AddPaymentFrame;
import com.danielmichalski.reservations.ui.forms.payment.view.modal.PaymentFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.payment.view.modal.PaymentFormPanel;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import com.danielmichalski.reservations.util.constant.ConstMessagesEN;
import com.danielmichalski.reservations.util.notification.Notifications;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.List;
import java.util.Optional;

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
    @SuppressWarnings("PMD.UnusedPrivateMethod")
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
            Notifications.showFormValidationAlert(validationError.message());
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
                JOptionPane.showMessageDialog(
                        null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE
                );
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

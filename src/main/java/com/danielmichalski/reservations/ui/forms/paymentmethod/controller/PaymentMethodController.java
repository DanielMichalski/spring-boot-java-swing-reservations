package com.danielmichalski.reservations.ui.forms.paymentmethod.controller;

import com.danielmichalski.reservations.commons.validation.ValidationError;
import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import com.danielmichalski.reservations.domain.payment.service.PaymentMethodService;
import com.danielmichalski.reservations.domain.payment.validation.PaymentMethodValidator;
import com.danielmichalski.reservations.ui.forms.paymentmethod.model.PaymentMethodTableModel;
import com.danielmichalski.reservations.ui.forms.paymentmethod.view.PaymentMethodTableBtnPanel;
import com.danielmichalski.reservations.ui.forms.paymentmethod.view.PaymentMethodTableFrame;
import com.danielmichalski.reservations.ui.forms.paymentmethod.view.modal.AddPaymentMethodFrame;
import com.danielmichalski.reservations.ui.forms.paymentmethod.view.modal.PaymentMethodFormBtnPanel;
import com.danielmichalski.reservations.ui.forms.paymentmethod.view.modal.PaymentMethodFormPanel;
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
public class PaymentMethodController extends AbstractFrameController {

    private final PaymentMethodTableFrame tableFrame;
    private final AddPaymentMethodFrame addFrame;
    private final PaymentMethodTableModel tableModel;
    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodValidator validator;

    @PostConstruct
    @SuppressWarnings("PMD.UnusedPrivateMethod")
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
        List<PaymentMethodEntity> entities = paymentMethodService.findAll();
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
        PaymentMethodEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.message());
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
                JOptionPane.showMessageDialog(
                        null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                PaymentMethodEntity entity = tableModel.getEntityByRow(selectedRow);
                paymentMethodService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

package pl.dmichalski.reservations.business.ui.forms.reservation_status.controller;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.app.service.reservation.ReservationStatusService;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.model.ReservationStatusTableModel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.ReservationStatusTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.ReservationStatusTableFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.AddReservationStatusFrame;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.ReservationStatusFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.reservation_status.view.modal.ReservationStatusFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;
import pl.dmichalski.reservations.business.util.notification.Notifications;
import pl.dmichalski.reservations.business.validation.ValidationError;
import pl.dmichalski.reservations.business.validation.reservation.ReservationStatusValidator;

@Controller
@AllArgsConstructor
public class ReservationStatusController extends AbstractFrameController {

    private final ReservationStatusTableFrame tableFrame;
    private final AddReservationStatusFrame addFrame;
    private final ReservationStatusTableModel tableModel;
    private final ReservationStatusService reservationStatusService;
    private final ReservationStatusValidator validator;

    @PostConstruct
    private void prepareListeners() {
        ReservationStatusTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        ReservationStatusFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<ReservationStatusEntity> entities = reservationStatusService.findAll();
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
        ReservationStatusFormPanel formPanel = addFrame.getFormPanel();
        ReservationStatusEntity entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            reservationStatusService.save(entity);
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
                ReservationStatusEntity entity = tableModel.getEntityByRow(selectedRow);
                reservationStatusService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}

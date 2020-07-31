package pl.dmichalski.reservations.business.ui.reports.reports.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.ui.reports.clientreservations.controller.ClientReservationsReportController;
import pl.dmichalski.reservations.business.ui.reports.payments.controller.PaymentReportController;
import pl.dmichalski.reservations.business.ui.reports.reports.view.ReportsFrame;
import pl.dmichalski.reservations.business.ui.reports.roomstatuses.controller.RoomStatusReportController;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class ReportsController extends AbstractFrameController {

    private final ReportsFrame mainMenuFrame;
    private final PaymentReportController paymentReportController;
    private final RoomStatusReportController roomStatusReportController;
    private final ClientReservationsReportController clientReservationsReportController;

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getPaymentMethodReportBtn(), (e) -> openPaymentMethodReportWindow());
        registerAction(mainMenuFrame.getRoomStatusesReportBtn(), (e) -> openRoomStatusReportWindow());
        registerAction(mainMenuFrame.getClientReservationsReportBtn(), (e) -> openClientReservationReportWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openPaymentMethodReportWindow() {
        paymentReportController.prepareAndOpenFrame();
    }

    private void openRoomStatusReportWindow() {
        roomStatusReportController.prepareAndOpenFrame();
    }

    private void openClientReservationReportWindow() {
        clientReservationsReportController.prepareAndOpenFrame();
    }

}

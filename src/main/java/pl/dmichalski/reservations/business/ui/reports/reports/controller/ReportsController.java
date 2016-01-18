package pl.dmichalski.reservations.business.ui.reports.reports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.ui.reports.payments.controller.PaymentReportController;
import pl.dmichalski.reservations.business.ui.reports.reports.view.ReportsFrame;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.controller.RoomStatusReportController;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.controller.ClientReservationsReportController;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
public class ReportsController extends AbstractFrameController {

    private ReportsFrame mainMenuFrame;
    private PaymentReportController paymentReportController;
    private RoomStatusReportController roomStatusReportController;
    private ClientReservationsReportController clientReservationsReportController;

    @Autowired
    public ReportsController(ReportsFrame mainMenuFrame,
                             PaymentReportController paymentReportController,
                             RoomStatusReportController roomStatusReportController,
                             ClientReservationsReportController clientReservationsReportController) {
        this.mainMenuFrame = mainMenuFrame;
        this.paymentReportController = paymentReportController;
        this.roomStatusReportController = roomStatusReportController;
        this.clientReservationsReportController = clientReservationsReportController;
    }

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.paymentMethodReportBtn(), (e) -> openPaymentMethodReportWindow());
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

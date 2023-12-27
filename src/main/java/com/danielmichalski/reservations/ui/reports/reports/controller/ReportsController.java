package com.danielmichalski.reservations.ui.reports.reports.controller;

import com.danielmichalski.reservations.ui.reports.clientreservations.controller.ClientReservationsReportController;
import com.danielmichalski.reservations.ui.reports.payments.controller.PaymentReportController;
import com.danielmichalski.reservations.ui.reports.reports.view.ReportsFrame;
import com.danielmichalski.reservations.ui.reports.roomstatuses.controller.RoomStatusReportController;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ReportsController extends AbstractFrameController {

    private final ReportsFrame mainMenuFrame;
    private final PaymentReportController paymentReportController;
    private final RoomStatusReportController roomStatusReportController;
    private final ClientReservationsReportController clientReservationsReportController;

    @Override
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

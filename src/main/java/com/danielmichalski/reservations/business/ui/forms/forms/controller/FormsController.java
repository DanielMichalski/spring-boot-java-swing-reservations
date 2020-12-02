package com.danielmichalski.reservations.business.ui.forms.forms.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.ui.forms.address.controller.AddressController;
import com.danielmichalski.reservations.business.ui.forms.client.controller.ClientController;
import com.danielmichalski.reservations.business.ui.forms.forms.view.FormsFrame;
import com.danielmichalski.reservations.business.ui.forms.payment.controller.PaymentController;
import com.danielmichalski.reservations.business.ui.forms.paymentmethod.controller.PaymentMethodController;
import com.danielmichalski.reservations.business.ui.forms.rate.controller.RateController;
import com.danielmichalski.reservations.business.ui.forms.reservation.controller.ReservationController;
import com.danielmichalski.reservations.business.ui.forms.reservationstatus.controller.ReservationStatusController;
import com.danielmichalski.reservations.business.ui.forms.room.controller.RoomController;
import com.danielmichalski.reservations.business.ui.forms.roomstatus.controller.RoomStatusController;
import com.danielmichalski.reservations.business.ui.forms.roomtype.controller.RoomTypeController;
import com.danielmichalski.reservations.business.ui.forms.roomxreservation.controller.RoomXReservationController;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class FormsController extends AbstractFrameController {

    private final FormsFrame mainMenuFrame;
    private final AddressController addressController;
    private final ClientController clientController;
    private final ReservationStatusController reservationStatusController;
    private final PaymentMethodController paymentMethodController;
    private final PaymentController paymentController;
    private final ReservationController reservationController;
    private final RoomStatusController roomStatusController;
    private final RoomTypeController roomTypeController;
    private final RoomController roomController;
    private final RateController rateController;
    private final RoomXReservationController roomXReservationController;

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getClientBtn(), (e) -> openClientsWindow());
        registerAction(mainMenuFrame.getAddressesBtn(), (e) -> openAddressWindow());
        registerAction(mainMenuFrame.getReservationStatusBtn(), (e) -> openReservationStatusWindow());
        registerAction(mainMenuFrame.getPaymentMethodBtn(), (e) -> openPaymentMethodWindow());
        registerAction(mainMenuFrame.getPaymentBtn(), (e) -> openPaymentWindow());
        registerAction(mainMenuFrame.getReservationBtn(), (e) -> openReservationWindow());
        registerAction(mainMenuFrame.getRoomStatusBtn(), (e) -> openRoomStatusWindow());
        registerAction(mainMenuFrame.getRoomTypeBtn(), (e) -> openRoomTypeWindow());
        registerAction(mainMenuFrame.getRoomBtn(), (e) -> openRoomWindow());
        registerAction(mainMenuFrame.getRateBtn(), (e) -> openRateWindow());
        registerAction(mainMenuFrame.getRoomXReservationBtn(), (e) -> openRoomXReservationBtnWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openAddressWindow() {
        addressController.prepareAndOpenFrame();
    }

    private void openClientsWindow() {
        clientController.prepareAndOpenFrame();
    }

    private void openReservationStatusWindow() {
        reservationStatusController.prepareAndOpenFrame();
    }

    private void openPaymentMethodWindow() {
        paymentMethodController.prepareAndOpenFrame();
    }

    private void openPaymentWindow() {
        paymentController.prepareAndOpenFrame();
    }

    private void openReservationWindow() {
        reservationController.prepareAndOpenFrame();
    }

    private void openRoomStatusWindow() {
        roomStatusController.prepareAndOpenFrame();
    }

    private void openRoomTypeWindow() {
        roomTypeController.prepareAndOpenFrame();
    }

    private void openRoomWindow() {
        roomController.prepareAndOpenFrame();
    }

    private void openRateWindow() {
        rateController.prepareAndOpenFrame();
    }

    private void openRoomXReservationBtnWindow() {
        roomXReservationController.prepareAndOpenFrame();
    }

}

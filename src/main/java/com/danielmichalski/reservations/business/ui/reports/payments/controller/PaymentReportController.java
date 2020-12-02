package com.danielmichalski.reservations.business.ui.reports.payments.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.payment.PaymentMethodService;
import com.danielmichalski.reservations.business.dto.payment.PaymentMethodCountDto;
import com.danielmichalski.reservations.business.ui.reports.payments.model.PaymentReportModel;
import com.danielmichalski.reservations.business.ui.reports.payments.view.PaymentReportTableFrame;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class PaymentReportController extends AbstractFrameController {

    private final PaymentReportTableFrame tableFrame;
    private final PaymentReportModel tableModel;
    private final PaymentMethodService paymentMethodService;

    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        tableModel.clear();
        List<PaymentMethodCountDto> paymentMethodCount = paymentMethodService.getPaymentMethodCount();
        tableModel.addEntities(paymentMethodCount);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

}

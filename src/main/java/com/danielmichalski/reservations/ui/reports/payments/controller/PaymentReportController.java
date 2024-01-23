package com.danielmichalski.reservations.ui.reports.payments.controller;

import com.danielmichalski.reservations.domain.payment.dto.PaymentMethodCountDto;
import com.danielmichalski.reservations.domain.payment.service.PaymentMethodService;
import com.danielmichalski.reservations.ui.reports.payments.model.PaymentReportModel;
import com.danielmichalski.reservations.ui.reports.payments.view.PaymentReportTableFrame;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PaymentReportController extends AbstractFrameController {

    private final PaymentReportTableFrame tableFrame;
    private final PaymentReportModel tableModel;
    private final PaymentMethodService paymentMethodService;

    @Override
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

package pl.dmichalski.reservations.business.ui.reports.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.domain.PaymentMethodCount;
import pl.dmichalski.reservations.business.service.PaymentMethodService;
import pl.dmichalski.reservations.business.ui.reports.payments.model.PaymentReportModel;
import pl.dmichalski.reservations.business.ui.reports.payments.view.PaymentReportTableFrame;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

import java.util.List;

@Controller
public class PaymentReportController extends AbstractFrameController {

    private PaymentReportTableFrame tableFrame;
    private PaymentReportModel tableModel;
    private PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentReportController(PaymentReportTableFrame tableFrame, PaymentReportModel tableModel, PaymentMethodService paymentMethodService) {
        this.tableFrame = tableFrame;
        this.tableModel = tableModel;
        this.paymentMethodService = paymentMethodService;
    }

    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        tableModel.clear();
        List<PaymentMethodCount> paymentMethodCount = paymentMethodService.getPaymentMethodCount();
        tableModel.addEntities(paymentMethodCount);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }


}

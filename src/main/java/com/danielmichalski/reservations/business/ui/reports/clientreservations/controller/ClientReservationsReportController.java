package com.danielmichalski.reservations.business.ui.reports.clientreservations.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.client.ClientService;
import com.danielmichalski.reservations.business.dto.client.ClientReservationCountDto;
import com.danielmichalski.reservations.business.ui.reports.clientreservations.model.ClientReservationsReportModel;
import com.danielmichalski.reservations.business.ui.reports.clientreservations.view.ClientReservationsReportTableFrame;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class ClientReservationsReportController extends AbstractFrameController {

    private final ClientReservationsReportTableFrame tableFrame;
    private final ClientReservationsReportModel tableModel;
    private final ClientService clientService;

    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        List<ClientReservationCountDto> entities = clientService.getClientReservationsCount();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

}

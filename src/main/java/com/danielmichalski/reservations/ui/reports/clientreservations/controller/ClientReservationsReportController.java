package com.danielmichalski.reservations.ui.reports.clientreservations.controller;

import com.danielmichalski.reservations.domain.client.dto.ClientReservationCountDto;
import com.danielmichalski.reservations.domain.client.service.ClientService;
import com.danielmichalski.reservations.ui.reports.clientreservations.model.ClientReservationsReportModel;
import com.danielmichalski.reservations.ui.reports.clientreservations.view.ClientReservationsReportTableFrame;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientReservationsReportController extends AbstractFrameController {

    private final ClientReservationsReportTableFrame tableFrame;
    private final ClientReservationsReportModel tableModel;
    private final ClientService clientService;

    @Override
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

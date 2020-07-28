package pl.dmichalski.reservations.business.ui.reports.client_reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.dto.client.ClientReservationCountDto;
import pl.dmichalski.reservations.business.service.client.ClientService;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.model.ClientReservationsReportModel;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.view.ClientReservationsReportTableFrame;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
public class ClientReservationsReportController extends AbstractFrameController {

    private ClientReservationsReportTableFrame tableFrame;
    private ClientReservationsReportModel tableModel;
    private ClientService clientService;

    @Autowired
    public ClientReservationsReportController(ClientReservationsReportTableFrame tableFrame,
                                              ClientReservationsReportModel tableModel,
                                              ClientService clientService) {
        this.tableFrame = tableFrame;
        this.tableModel = tableModel;
        this.clientService = clientService;
    }

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

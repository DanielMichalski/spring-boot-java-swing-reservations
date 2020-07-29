package pl.dmichalski.reservations.business.ui.reports.client_reservations.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.app.service.client.ClientService;
import pl.dmichalski.reservations.business.dto.client.ClientReservationCountDto;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.model.ClientReservationsReportModel;
import pl.dmichalski.reservations.business.ui.reports.client_reservations.view.ClientReservationsReportTableFrame;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

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

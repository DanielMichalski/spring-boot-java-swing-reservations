package pl.dmichalski.reservations.business.ui.reports.room_statuses.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.app.service.room.RoomStatusService;
import pl.dmichalski.reservations.business.dto.room.RoomStatusesCountDto;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.model.RoomStatusReportModel;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.view.RoomStatusReportTableFrame;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class RoomStatusReportController extends AbstractFrameController {

    private final RoomStatusReportTableFrame tableFrame;
    private final RoomStatusReportModel tableModel;
    private final RoomStatusService roomStatusService;

    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        tableModel.clear();
        List<RoomStatusesCountDto> entities = roomStatusService.getRoomStatusesCount();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

}

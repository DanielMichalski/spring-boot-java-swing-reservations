package pl.dmichalski.reservations.business.ui.reports.room_statuses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.entity.domain.RoomStatusesCount;
import pl.dmichalski.reservations.business.service.RoomStatusService;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.model.RoomStatusReportModel;
import pl.dmichalski.reservations.business.ui.reports.room_statuses.view.RoomStatusReportTableFrame;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
public class RoomStatusReportController extends AbstractFrameController {

    private RoomStatusReportTableFrame tableFrame;
    private RoomStatusReportModel tableModel;
    private RoomStatusService roomStatusService;

    @Autowired
    public RoomStatusReportController(RoomStatusReportTableFrame tableFrame, RoomStatusReportModel tableModel, RoomStatusService roomStatusService) {
        this.tableFrame = tableFrame;
        this.tableModel = tableModel;
        this.roomStatusService = roomStatusService;
    }

    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        tableModel.clear();
        List<RoomStatusesCount> entities = roomStatusService.getRoomStatusesCount();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

}

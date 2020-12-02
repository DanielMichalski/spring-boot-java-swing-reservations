package com.danielmichalski.reservations.business.ui.reports.roomstatuses.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.app.service.room.RoomStatusService;
import com.danielmichalski.reservations.business.dto.room.RoomStatusesCountDto;
import com.danielmichalski.reservations.business.ui.reports.roomstatuses.model.RoomStatusReportModel;
import com.danielmichalski.reservations.business.ui.reports.roomstatuses.view.RoomStatusReportTableFrame;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

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

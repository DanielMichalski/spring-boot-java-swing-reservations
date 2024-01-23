package com.danielmichalski.reservations.ui.reports.roomstatuses.controller;

import com.danielmichalski.reservations.domain.room.dto.RoomStatusesCountDto;
import com.danielmichalski.reservations.domain.room.service.RoomStatusService;
import com.danielmichalski.reservations.ui.reports.roomstatuses.model.RoomStatusReportModel;
import com.danielmichalski.reservations.ui.reports.roomstatuses.view.RoomStatusReportTableFrame;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class RoomStatusReportController extends AbstractFrameController {

    private final RoomStatusReportTableFrame tableFrame;
    private final RoomStatusReportModel tableModel;
    private final RoomStatusService roomStatusService;

    @Override
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

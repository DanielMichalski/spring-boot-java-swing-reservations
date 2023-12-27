package com.danielmichalski.reservations.ui.mainmenu.controller;

import com.danielmichalski.reservations.ui.forms.forms.controller.FormsController;
import com.danielmichalski.reservations.ui.mainmenu.view.MainMenuFrame;
import com.danielmichalski.reservations.ui.reports.reports.controller.ReportsController;
import com.danielmichalski.reservations.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final FormsController formsController;
    private final ReportsController reportsController;

    @Override
    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getFormsBtn(), (e) -> openFormsWindow());
        registerAction(mainMenuFrame.getReportsBtn(), (e) -> openReportsWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openFormsWindow() {
        formsController.prepareAndOpenFrame();
    }

    private void openReportsWindow() {
        reportsController.prepareAndOpenFrame();
    }

}

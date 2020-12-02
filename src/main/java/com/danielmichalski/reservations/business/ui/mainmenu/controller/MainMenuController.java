package com.danielmichalski.reservations.business.ui.mainmenu.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.danielmichalski.reservations.business.ui.forms.forms.controller.FormsController;
import com.danielmichalski.reservations.business.ui.mainmenu.view.MainMenuFrame;
import com.danielmichalski.reservations.business.ui.reports.reports.controller.ReportsController;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
@AllArgsConstructor
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final FormsController formsController;
    private final ReportsController reportsController;

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

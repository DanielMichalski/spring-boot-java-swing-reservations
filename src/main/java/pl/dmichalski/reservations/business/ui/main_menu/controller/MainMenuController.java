package pl.dmichalski.reservations.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.ui.forms.forms.controller.FormsController;
import pl.dmichalski.reservations.business.ui.main_menu.view.MainMenuFrame;
import pl.dmichalski.reservations.business.ui.reports.reports.controller.ReportsController;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {

    private MainMenuFrame mainMenuFrame;
    private FormsController formsController;
    private ReportsController reportsController;

    @Autowired
    public MainMenuController(MainMenuFrame mainMenuFrame, FormsController formsController, ReportsController reportsController) {
        this.mainMenuFrame = mainMenuFrame;
        this.formsController = formsController;
        this.reportsController = reportsController;
    }

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

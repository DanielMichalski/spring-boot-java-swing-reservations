package pl.dmichalski.reservations.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.ui.main_menu.view.MainMenuFrame;
import pl.dmichalski.reservations.business.ui.shared.AbstractFrameController;
import pl.dmichalski.reservations.business.ui.client.controller.ClientController;

@Controller
public class MainMenuController extends AbstractFrameController {

    private MainMenuFrame mainMenuFrame;
    private ClientController clientController;

    @Autowired
    public MainMenuController(MainMenuFrame mainMenuFrame,
                              ClientController clientController) {
        this.mainMenuFrame = mainMenuFrame;
        this.clientController = clientController;
    }

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getClientBtn(), (e) -> openClientsWindow());
        registerAction(mainMenuFrame.getReservationBtn(), (e) -> btn2());
        registerAction(mainMenuFrame.getAddressesBtn(), (e) -> btn3());
        mainMenuFrame.setVisible(true);
    }

    private void closeWindow() {
        this.mainMenuFrame.dispose();
    }

    private void openClientsWindow() {
        closeWindow();
        clientController.prepareAndOpenFrame();
    }

    private void btn2() {
        closeWindow();
        System.out.println("btn2");
    }

    private void btn3() {
        closeWindow();
        System.out.println("btn3");
    }



}

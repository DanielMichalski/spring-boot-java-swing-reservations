package pl.dmichalski.reservations.business.util;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert() {
        JOptionPane.showMessageDialog(null,
                ConstMessages.Messages.FORM_VALIDATION_ALERT,
                ConstMessages.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                ConstMessages.Messages.NON_ROW_SELECTED,
                ConstMessages.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

}

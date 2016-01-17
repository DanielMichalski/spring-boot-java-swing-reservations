package pl.dmichalski.reservations.business.util;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                ConstMessages.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                ConstMessages.Messages.NON_ROW_SELECTED,
                ConstMessages.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessages.Messages.DELETE_ROW_ERROR,
                ConstMessages.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }
}

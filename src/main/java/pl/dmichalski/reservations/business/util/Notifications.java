package pl.dmichalski.reservations.business.util;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                ConstMessagesEN.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.NON_ROW_SELECTED,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.DELETE_ROW_ERROR,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }
}

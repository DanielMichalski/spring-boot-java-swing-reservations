package com.danielmichalski.reservations.util.notification;

import com.danielmichalski.reservations.util.constant.ConstMessagesEN;

import javax.swing.JOptionPane;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                ConstMessagesEN.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(
                null,
                ConstMessagesEN.Messages.DELETE_ROW_ERROR,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE
        );
    }
}

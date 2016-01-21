package pl.dmichalski.reservations.business.util;

import javax.swing.*;

public class LookAndFeelUtils {

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    ConstMessagesEN.Messages.WINDOWS_STYLE_LOADING_ERROR_MESSAGE + e,
                    ConstMessagesEN.Messages.ALERT_TILE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}

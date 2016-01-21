package pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomXReservationTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private RoomXReservationTablePanel tablePanel;
    private RoomXReservationTableBtnPanel tableBtnPanel;

    @Autowired
    public RoomXReservationTableFrame(RoomXReservationTableBtnPanel tableBtnPanel, RoomXReservationTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.ROOM_X_RESERVATIONS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public RoomXReservationTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public RoomXReservationTablePanel getTablePanel() {
        return tablePanel;
    }
}

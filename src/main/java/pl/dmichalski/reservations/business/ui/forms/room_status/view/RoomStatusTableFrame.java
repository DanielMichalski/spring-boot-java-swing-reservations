package pl.dmichalski.reservations.business.ui.forms.room_status.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomStatusTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private RoomStatusTablePanel tablePanel;
    private RoomStatusTableBtnPanel tableBtnPanel;

    @Autowired
    public RoomStatusTableFrame(RoomStatusTableBtnPanel tableBtnPanel, RoomStatusTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.ROOM_STATUSES);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public RoomStatusTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public RoomStatusTablePanel getTablePanel() {
        return tablePanel;
    }
}

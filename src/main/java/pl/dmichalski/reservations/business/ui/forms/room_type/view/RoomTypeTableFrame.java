package pl.dmichalski.reservations.business.ui.forms.room_type.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class RoomTypeTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private RoomTypeTablePanel tablePanel;
    private RoomTypeTableBtnPanel tableBtnPanel;

    @Autowired
    public RoomTypeTableFrame(RoomTypeTableBtnPanel tableBtnPanel, RoomTypeTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.ROOM_TYPES);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public RoomTypeTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public RoomTypeTablePanel getTablePanel() {
        return tablePanel;
    }
}

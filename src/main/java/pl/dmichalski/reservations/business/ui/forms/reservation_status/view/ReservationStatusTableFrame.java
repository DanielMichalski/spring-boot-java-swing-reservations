package pl.dmichalski.reservations.business.ui.forms.reservation_status.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class ReservationStatusTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;

    private ReservationStatusTablePanel tablePanel;
    private ReservationStatusTableBtnPanel tableBtnPanel;

    @Autowired
    public ReservationStatusTableFrame(ReservationStatusTableBtnPanel tableBtnPanel, ReservationStatusTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.RESERVATION_STATUSES);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public ReservationStatusTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public ReservationStatusTablePanel getTablePanel() {
        return tablePanel;
    }
}

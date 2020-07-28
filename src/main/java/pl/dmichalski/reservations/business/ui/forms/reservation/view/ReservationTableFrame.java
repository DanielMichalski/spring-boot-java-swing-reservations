package pl.dmichalski.reservations.business.ui.forms.reservation.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.constant.ConstMessagesEN;

@Component
public class ReservationTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 300;

    private ReservationTablePanel tablePanel;
    private ReservationTableBtnPanel tableBtnPanel;

    @Autowired
    public ReservationTableFrame(ReservationTableBtnPanel tableBtnPanel, ReservationTablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.RESERVATIONS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public ReservationTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public ReservationTablePanel getTablePanel() {
        return tablePanel;
    }
}

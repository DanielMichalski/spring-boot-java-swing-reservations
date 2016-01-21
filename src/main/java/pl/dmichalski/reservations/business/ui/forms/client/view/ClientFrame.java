package pl.dmichalski.reservations.business.ui.forms.client.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class ClientFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;

    private ClientTablePanel clientTablePanel;
    private TableBtnPanel tableBtnPanel;

    @Autowired
    public ClientFrame(TableBtnPanel tableBtnPanel, ClientTablePanel clientTablePanel) {
        this.clientTablePanel = clientTablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.CLIENTS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(clientTablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public TableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public ClientTablePanel getTablePanel() {
        return clientTablePanel;
    }
}

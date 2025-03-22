package project.hms.utils;

import javax.swing.*;
import java.awt.*;
import project.hms.panels.*;

public class CenterPanelManager extends JPanel {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public CenterPanelManager() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);  // The actual container

        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        contentPanel.add(new PatientRecord(), "PatientRecords");
        contentPanel.add(new BookingPanel(), "Booking");
        /*
        contentPanel.add(new SchedulePanel(), "Schedule");
        */
        contentPanel.add(new StaffRecord(), "StaffRecords");
        
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
        System.out.println("tite");
    }
}

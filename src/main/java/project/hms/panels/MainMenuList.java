package project.hms.panels;

import javax.swing.*;
import java.awt.*;
import project.hms.MainFrame;

public class MainMenuList extends JPanel {
    private final JButton[] buttons;
    private DashboardPanel dashboardPanel;

    public MainMenuList() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons = new JButton[]{
            createStyledButton("Patient Records"),
            createStyledButton("Booking"),
            createStyledButton("Schedule"),
            createStyledButton("Staff Record"),
            createStyledButton("Logout")
        };

        buttons[0].addActionListener(e -> switchPanel("PatientRecords"));
        buttons[1].addActionListener(e -> switchPanel("Booking"));
        buttons[2].addActionListener(e -> switchPanel("Schedule"));
        buttons[3].addActionListener(e -> switchPanel("StaffRecords"));
        buttons[4].addActionListener(e -> logout());

        for (JButton button : buttons) {
            this.add(button);
            this.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(200, 40));
        button.setMinimumSize(new Dimension(200, 40));
        button.setMaximumSize(new Dimension(200, 40));

        button.setBackground(new Color(50, 50, 50));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        button.setFont(new Font("Arial", Font.BOLD, 14));

        return button;
    }

    public void setDashboardPanel(DashboardPanel dashboardPanel) {
        this.dashboardPanel = dashboardPanel;
    }

    private void switchPanel(String panelName) {
        if (dashboardPanel != null) {
            dashboardPanel.switchPanel(panelName);
        } else {
            System.err.println("ERROR: dashboardPanel is NULL! Set it using setDashboardPanel().");
        }
    }

    private void logout() {
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        if (mainFrame != null) {
            mainFrame.showLogin();
        }
    }
}

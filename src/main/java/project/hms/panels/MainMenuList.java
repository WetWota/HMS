package project.hms.panels;

import javax.swing.*;
import java.awt.*;
import project.hms.MainFrame;

public class MainMenuList extends JPanel{
    private final JButton[] buttons;
    private DashboardPanel dashboardPanel;

    public MainMenuList() {
        
        int numberOfButtons = 5;
        buttons = new JButton[numberOfButtons];

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons[0] = new JButton("Patient records");        
        buttons[1] = new JButton("Booking");
        buttons[2] = new JButton("Schedule");
        buttons[3] = new JButton("Staff record");
        buttons[4] = new JButton("Logout");
        
        buttons[0].addActionListener(e -> dashboardPanel.switchPanel("PatientRecords"));
        buttons[1].addActionListener(e -> dashboardPanel.switchPanel("Booking"));
        /*
        buttons[2].addActionListener(e -> dashboardPanel.switchPanel("Schedule"));
*/
        buttons[3].addActionListener(e -> dashboardPanel.switchPanel("StaffRecords"));
        
        buttons[4].addActionListener(e -> logout());
        
        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(buttons[i]);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
            setButtonSize(buttons[i], 200, 40);
        }
    }
    
    
    public void setButtonSize(JButton button, int width, int height) {
        button.setPreferredSize(new java.awt.Dimension(width, height));
        button.setMinimumSize(new java.awt.Dimension(width, height));
        button.setMaximumSize(new java.awt.Dimension(width, height));
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
    
    private void logout(){
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        if (mainFrame != null) {
            mainFrame.showLogin();
        }
    }
    
    
}

package project.hms.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuList extends JPanel implements ActionListener {
    
    private final JButton[] buttons;

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
        
        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            buttons[i].addActionListener(this); 
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                JOptionPane.showMessageDialog(this, "Button " + (i + 1) + " clicked!");
                break;
            }
        }
    }
}

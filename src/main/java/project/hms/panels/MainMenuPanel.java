package project.hms.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel implements ActionListener {
    
    private final JButton[] buttons;

    public MainMenuPanel() {
        int numberOfButtons = 5;
        buttons = new JButton[numberOfButtons];

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < numberOfButtons; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            buttons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            buttons[i].addActionListener(this); 
            this.add(buttons[i]);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }
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

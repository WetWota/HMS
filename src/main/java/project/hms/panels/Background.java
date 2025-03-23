package project.hms.panels;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Image backgroundImage;

    public Background() {
        // Load image from resources
        backgroundImage = new ImageIcon(getClass().getResource("/images/zomboid.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

package project.hms.panels;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Image backgroundImage;

    public Background() {
        backgroundImage = new ImageIcon(getClass().getResource("/images/zomboid.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            g.setColor(new Color(0, 0, 0, 150)); // 128 = 50% transparency
            g.fillRect(0, 0, getWidth(), getHeight()); 
        }
    }

}

package drawing.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        graphics.setColor(Color.DARK_GRAY);
        
        // eyes
        graphics.fillRect(100, 35, 50, 50);
        graphics.fillRect(250, 35, 50, 50);
        
        // mouth
        graphics.fillRect(50, 195, 50, 50);
        graphics.fillRect(300, 195, 50, 50);
        graphics.fillRect(100, 245, 200, 50);
    }
}

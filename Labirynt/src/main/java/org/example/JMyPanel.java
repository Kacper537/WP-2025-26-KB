package org.example;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JMyPanel extends JPanel {
    private Image image;

    public JMyPanel() {
        // Initialize the image to avoid null in drawing
        image = createImage(600, 300);
    }

    public  Image getImage(){
        return image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image == null)
            image = createImage(getWidth(),getHeight());
        else
            g.drawImage(image, 0,0,this);
    }
}

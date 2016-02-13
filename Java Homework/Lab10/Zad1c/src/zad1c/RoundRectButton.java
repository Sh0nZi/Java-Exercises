package zad1c;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundRectButton extends JButton {

    private Color baseColor;
    private Color clickColor;

    public RoundRectButton(String label, int width, int heigth, Color baseColor, Color clickColor) {
        super(label);

// These statements enlarge the button so that it 
// becomes a circle rather than an oval.
        this.baseColor = baseColor;
        this.clickColor = clickColor;
        Dimension size = getPreferredSize();
        size.width = width;
        size.height = heigth;
        setPreferredSize(size);

// This call causes the JButton not to paint 
        // the background.
// This allows us to paint a round background.
        setContentAreaFilled(false);
    }

    public void setWidth(int width) {
        Dimension size = getPreferredSize();
        size.width = width;
        size.height = this.getHeight();
        setPreferredSize(size);
        repaint();
    }

    public void setHeigth(int heigth) {
        Dimension size = getPreferredSize();
        size.width = this.getWidth();
        size.height = heigth;
        setPreferredSize(size);
        repaint();
    }

    public Color getBaseColor() {
        return this.baseColor;
    }

    public void setBaseColor(Color color) {
        this.baseColor = color;
    }

    public Color getClickColor() {
        return this.clickColor;
    }

    public void setClickColor(Color color) {
        this.clickColor = color;
        repaint();
    }

    public int getArcWidthHeigth() {
        return Math.min(this.getWidth(), this.getHeight())/ 2;
    }

// Paint the round background and label.
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
// You might want to make the highlight color 
            // a property of the RoundRectButton class.
            g.setColor(this.getClickColor());
        } else {
            g.setColor(this.getBaseColor());
        }
        g.fillRoundRect(0, 0, getSize().width - 1,
                getSize().height - 1, this.getArcWidthHeigth(), this.getArcWidthHeigth());

// This call will paint the label and the 
        // focus rectangle.
        super.paintComponent(g);
    }

// Paint the border of the button using a simple stroke.
    protected void paintBorder(Graphics g) {
        if (getModel().isArmed()) {
// You might want to make the highlight color 
            // a property of the RoundRectButton class.
            g.setColor(this.getClickColor());
        } else {
            g.setColor(this.getBaseColor());
        }
        g.fillRoundRect(0, 0, getSize().width - 1,
                getSize().height - 1, this.getArcWidthHeigth(),this.getArcWidthHeigth());
    }

// Hit detection.
    Shape shape;

    public boolean contains(int x, int y) {
// If the button has changed size, 
        // make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0,
                    getWidth(), getHeight(), this.getArcWidthHeigth(),this.getArcWidthHeigth());
        }
        return shape.contains(x, y);
    }
}

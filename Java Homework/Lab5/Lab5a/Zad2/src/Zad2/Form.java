/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author sstoyanov
 */
public class Form extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Point uPoint = new Point(10, 10);
        Point lPoint = new Point(50, 50);
        Rectangle rect = new Rectangle(uPoint, lPoint);
        Rectangle anotherRect = new Rectangle(rect);
        anotherRect.setUPoint(lPoint);
        Point anotherLPoint = new Point(lPoint.getX() + 40,lPoint.getY() + 40);
        anotherRect.setLPoint(anotherLPoint);
        
        Point sPoint = new Point(10, 90);
        Point ePoint = new Point(90, 10);
        Line line = new Line(sPoint, ePoint);

        rect.draw(g);
        anotherRect.draw(g);
        line.draw(g);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Form panel = new Form();

        frame.add(panel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

}

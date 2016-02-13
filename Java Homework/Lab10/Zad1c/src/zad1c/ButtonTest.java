/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1c;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sstoyanov
 */
public class ButtonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JButton button = new RoundRectButton("Change", 400, 200, Color.RED, Color.GREEN);
        button.setBackground(Color.blue);
// Create a frame in which to show the button.
        JFrame frame = new JFrame("Button sample");
        frame.getContentPane().setBackground(Color.darkGray);
        frame.getContentPane().add(button);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(1200, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

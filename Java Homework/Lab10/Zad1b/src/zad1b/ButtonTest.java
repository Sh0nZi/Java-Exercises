/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1b;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sstoyanov
 */
public class ButtonTest {

  // Test routine.
  public static void main(String[] args) {
// Create a button with the label "Jackpot".
    JButton button = new RoundButton("Jackpot");
    button.setBackground(Color.blue);

// Create a frame in which to show the button.
    JFrame frame = new JFrame("Button sample");
    frame.getContentPane().setBackground(Color.darkGray);
    frame.getContentPane().add(button);
    frame.getContentPane().setLayout(new FlowLayout());
    frame.setSize(150, 150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
    
}

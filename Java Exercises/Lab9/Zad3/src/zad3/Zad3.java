/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sstoyanov
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(200, 100);
        JButton btn = new JButton();
        btn.setText("Click me");
        btn.addActionListener((e) -> JOptionPane.showMessageDialog(null, "JButton event handler"));
        mainFrame.add(btn);
        mainFrame.setVisible(true);
    }

}

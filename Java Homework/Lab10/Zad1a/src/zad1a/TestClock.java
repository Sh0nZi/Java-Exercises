/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1a;

import javax.swing.JFrame;

/**
 *
 * @author sstoyanov
 */
public class TestClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnimatedClock clock = new AnimatedClock();
        JFrame frame = new JFrame("Clock sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(clock);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

}

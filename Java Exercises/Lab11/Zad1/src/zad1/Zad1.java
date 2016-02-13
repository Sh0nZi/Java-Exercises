/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import javax.swing.JFrame;

/**
 *
 * @author sstoyanov
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(400, 400);
        StillClock cl = new AnimatedClock();
        fr.add(cl);
        fr.setVisible(true);
    }
    
}

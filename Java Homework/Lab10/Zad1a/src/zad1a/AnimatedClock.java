/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author sstoyanov
 */
public class AnimatedClock extends StillClock {

    private class UpdateClock implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setCurrentTime();
            repaint();
        }
    }

    public AnimatedClock() {
        Timer timer = new Timer(1000, new UpdateClock());
        timer.start();
    }
}

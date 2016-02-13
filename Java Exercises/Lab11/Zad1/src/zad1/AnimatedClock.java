/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author sstoyanov
 */
public class AnimatedClock extends StillClock {

    private final Timer timer;
    private StringBuilder sb;
    private boolean isStarted = false;

    public AnimatedClock() {
        sb = new StringBuilder();
        timer = new Timer(1000, (e) -> {

            sb.append(String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond())).append(System.lineSeparator());
            setCurrentTime();
            repaint();
        });

        JButton btn = new JButton();
        btn.setText("Start");
        btn.addActionListener((e) -> {
            if (isStarted) {
                btn.setText("Start");
                this.stop();
            } else {
                btn.setText("Stop");
                this.start();
            }
            isStarted = !isStarted;
        });
        this.add(btn);
    }

    private void start() {
        sb.append("Clock started").append(System.lineSeparator());
        this.timer.start();
    }

    private void stop() {
        sb.append("Clock stopped").append(System.lineSeparator());
        this.writeToFile();
        this.timer.stop();
    }

    private void writeToFile() {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("ticks.txt", true));
            ous.writeObject(this.sb.toString());
            this.sb = new StringBuilder();
        } catch (IOException ex) {

        }

    }
}

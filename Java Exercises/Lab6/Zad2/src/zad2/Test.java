/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.io.IOException;

/**
 *
 * @author sstoyanov
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        TrafficLights[] lights = new TrafficLights[]{
            TrafficLights.RED,
            TrafficLights.YELLOW,
            TrafficLights.GREEN,
            TrafficLights.YELLOW,};

        long end = 0;

        int i = 0;
        while (end < 10000) {
            System.out.println(lights[i]);
            lights[i].delay();
            end += lights[i].duration();
            i++;
            if (i == lights.length) {
                i = 0;
            }
        }
    }

}

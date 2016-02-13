/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author sstoyanov
 */
public enum TrafficLights {
    RED(1500),
    GREEN(1500),
    YELLOW(500);
    
    private final int duration;

    private TrafficLights(int duration){
        this.duration = duration;
    }  
    
    public int duration(){
        return this.duration;
    }
    
    public void delay() throws InterruptedException{
        Thread.sleep(this.duration);
    } 
}

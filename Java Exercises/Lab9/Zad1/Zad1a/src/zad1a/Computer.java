/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1a;

/**
 *
 * @author sstoyanov
 */
public class Computer  {
    
    private final double cpuSpeed;
    
    public Computer(double cpuSpeed){
        this.cpuSpeed = cpuSpeed;
    }
    
    public double getCpuSpeed(){
        return this.cpuSpeed;
    }
    
    @Override
    public boolean equals(Object o){
        Computer c = (Computer)o;
        if(c == null){
            return false;
        }
        return this.getCpuSpeed() == c.getCpuSpeed();
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int)this.cpuSpeed;
        return hash;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author sstoyanov
 */
public class Range {

    private final int min;
    private final int max;
    
    public Range(int min, int max){
     this.min = min;
     this.max = max;
    }
    
    public int getRandomDigit(){
       return min + (int)(Math.random() * ((max - min) + 1));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class SequenceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sequence seq = new Sequence(8);
        Random r = new Random();
        
        for (int i = 0; i < 8; i++) {
            seq.add(r.nextInt(90) + 10);
        }
        
        Selector selector = seq.getSelector();
        while(!selector.end()){
            System.out.printf("%1s ", selector.current());
            selector.next();
        }       
        System.out.println();
        
        selector = seq.getRSelector();
        while(!selector.end()){
            System.out.printf("%1s ", selector.current());
            selector.next();
        }       
        System.out.println();
    }
    
}

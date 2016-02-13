/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1b;

import java.util.function.Function;

/**
 *
 * @author sstoyanov
 */
public class Zad1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        method((number) -> (double)Math.round(number));
        method((number) -> Zad1b.floor(number));
        method((number) -> new Zad1b().exp(number));
    }

    public static void method(Function<Double, Double> function) {
        System.out.println(function.apply(3.54));
    }

    public static double floor(double num){
        return Math.floor(num);
    }
    
    public double exp(double num){
        return Math.exp(num);
    }
    
}

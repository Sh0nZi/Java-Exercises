/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2b;

import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class Zad2b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter x: ");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.print("Enter accuracy: ");
        double accuracy = sc.nextDouble();
        System.out.printf("Accurate cos(x) = %1"+  accuracy +"f\n", cos(x));
        System.out.printf("Approximate cos(x) = %1f", Math.cos(x));
    }
    
    private static double cos(double x){
        double a = 1.0;
        
        for (int i = 2; i <= 10; i+=2) {
            a = a + Math.pow(-1, i -1) * Math.pow(x, i)/fac(i);
        }
        
        return a;
    }
    
    private static double fac(int i ){
        int res = 1;
        for (int j = 2; j <= i; j++) {
            res *=j;
        }
        
        return res;
    }
}

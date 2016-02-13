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
public class RationalTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rational rat1 = new Rational(3, -4);
        Rational rat2 = new Rational(-4, 3);
        Rational rat3 = new Rational(-6, 8);
        
        System.out.printf("%1s = %2s\n", rat1, rat3);
        System.out.println(rat1.add(rat2));
        System.out.println(rat1.subtract(rat2));
        System.out.println(rat1.divideBy(rat3));
        System.out.println(rat1.multiplyBy(rat3));
        
    }

}

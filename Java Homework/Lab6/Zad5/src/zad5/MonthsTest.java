/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

/**
 *
 * @author sstoyanov
 */
public class MonthsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Months.JAN = " + Months.JAN);
        System.out.println("Months.Month[0] = " + Months.Month[0]);
        System.out.println("Are equal? " + (Months.JAN == Months.Month[0]));
        
        System.out.println("Months.NOV = " + Months.NOV);
        System.out.println("Months.Month[10] = " + Months.Month[10]);
        System.out.println("Are equal? " + (Months.NOV == Months.Month[10]));
    }
    
}

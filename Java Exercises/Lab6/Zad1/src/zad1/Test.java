/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author sstoyanov
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point pt1 = new Point();
        Point pt2 = new Point(200, 100);
        
        System.out.println("Point 1: " + pt1);
        System.out.println("Point 2: " + pt2);
        
        Line ln = new Line(pt1, pt2);
        System.out.println("Line: " + ln);
        System.out.println("Line length: " + ln.measure());
        
        Rectangle rect = new Rectangle(pt1, pt2);
        System.out.println("Rectangle: " + rect);
        System.out.println("Rectangle perimeter: " + rect.measure());
    }
    
}

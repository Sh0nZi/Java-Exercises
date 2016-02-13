/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class BubbleSortTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        
        Point[] comparables = new Point[3];
        
        for (int i = 0; i < comparables.length; i++) {
            comparables[i]= new Point(rand.nextInt(40) + 10, rand.nextInt(40) + 10);
        }
        
        BubbleSort.sortArray(comparables);
        Arrays.asList(comparables).forEach((e) -> System.out.print(e + " "));
        System.out.println();
        
        
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(comparables[1].getX(), comparables[1].getY(), rand.nextInt(20) + 10);
        for (int i = 1; i < comparables.length; i++) {
            circles[i]= new Circle(comparables[i].getX(), comparables[i].getY(),rand.nextInt(20) + 10);
        }
        
        BubbleSort.sortArray(circles);
        Arrays.asList(circles).forEach((e) -> System.out.print(e + " "));
        System.out.println();
        
        Cylinder[] cylinders = new Cylinder[3];
        cylinders[0] = new Cylinder(circles[1].getX(), circles[1].getY(),
                circles[1].getR(), rand.nextInt(20) + 50);
        for (int i = 1; i < comparables.length; i++) {
            cylinders[i]= new Cylinder(circles[i].getX(), circles[i].getY(),
                    circles[i].getR(), rand.nextInt(20) + 50);
        }
        
        BubbleSort.sortArray(cylinders);
        Arrays.asList(cylinders).forEach((e) -> System.out.print(e + " "));
        System.out.println();
    }
    
    
    
}

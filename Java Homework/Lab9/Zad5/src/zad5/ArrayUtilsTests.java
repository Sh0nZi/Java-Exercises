/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author sstoyanov
 */
public class ArrayUtilsTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = ArrayUtils.generateRandom(10, 50);
        Predicate<Integer> isEven = (n) -> n % 2 == 0; 
        Predicate<Integer> isOdd = (n) -> n % 2 == 1; 
        Predicate<Integer> isInRange = (n) -> 30 <= n && n <= 40;
        Predicate<Integer> allNumbers = (n) -> true;
        
        System.out.print("All numbers: ");
        displayArray(ArrayUtils.filterNumbers(allNumbers, numbers));
         
        System.out.print("Even numbers: ");
        displayArray(ArrayUtils.filterNumbers(isEven, numbers));
        
        System.out.print("Odd numbers: ");
        displayArray(ArrayUtils.filterNumbers(isOdd, numbers));
        
        System.out.print("Numbers between 30 and 40: ");
        displayArray(ArrayUtils.filterNumbers(isInRange, numbers));
    }
    
    private static void displayArray(List<Integer> numbers){
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.print(System.lineSeparator());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class UseSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(200);
        }
        System.out.print("Initial: ");
        printArray(numbers);

        SortOrder order = new SortOrder();
        MySort sorter = new MySort(order.ascending());
        sorter.sort(numbers);
        System.out.print("Ascending: ");
        printArray(numbers);

        sorter = new MySort(order.descending());
        sorter.sort(numbers);
        System.out.print("Descending: ");
        printArray(numbers);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%1s ", arr[i]);
        }
        System.out.println();
    }

}

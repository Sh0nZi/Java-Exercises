/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2d;

import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class Zad2d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] unsortedArray = new int[20];
        Random rand = new Random();
        SortUtils sorter = new SortUtils();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted array: ");
        sorter.print(unsortedArray);
        int[] sortedArray = sorter.mergeSort(unsortedArray);
        System.out.println("Sorted array: ");
        sorter.print(sortedArray);
    }
}

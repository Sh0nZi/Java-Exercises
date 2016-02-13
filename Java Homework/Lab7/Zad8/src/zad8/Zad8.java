/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad8;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 * @author sstoyanov
 */
public class Zad8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] unsortedNumbers = new int[]{-5, 2, 0, 12, 7, 9, -6, 3, 1, 4};
        printCollection(unsortedNumbers);
        SelectionSort sorter = new SelectionSort(unsortedNumbers);
        int[] sortedNumbers = sorter.getSortedCollection();
        printCollection(sortedNumbers);
       
    }
    
    private static void printCollection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(System.lineSeparator());
    }
}

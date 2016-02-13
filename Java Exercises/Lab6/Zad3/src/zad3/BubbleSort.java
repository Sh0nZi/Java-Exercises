/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author sstoyanov
 */
public class BubbleSort {

    public static void sortArray(IComparable[] arr) {
        int n = arr.length;
        while (n != 0) {
            int newN = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].greater(arr[i])) {
                    swap(arr, i - 1, i);
                    newN = i;
                }
            }
            n = newN;
        }
    }

    private static void swap(IComparable[] arr, int i, int j) {
        IComparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

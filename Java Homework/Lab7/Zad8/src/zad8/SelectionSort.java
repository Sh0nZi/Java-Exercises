/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad8;

/**
 *
 * @author sstoyanov
 */
public class SelectionSort implements Sortable {

    private int[] numbers;

    public SelectionSort(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean greater(int i, int j) {
        return numbers[i] > numbers[j];
    }

    public int[] getSortedCollection(){
        sort();
        return numbers;
    }
    
    private int[] sort() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (greater(i, j)) {
                    swap(i, j);
                }
            }
        }
        return numbers;
    }
    
    private void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}

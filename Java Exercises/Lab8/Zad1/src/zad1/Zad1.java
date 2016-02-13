/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{4, 8, 3},
            new Integer[]{2, 9, 6},
            new Integer[]{12, 5, 8}
        };

        int max = max(matrix);
        System.out.println("Max number in two-dimensional array: " + max);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        shuffle(list);
        System.out.print("Shufled numbers from 1 to 10:  ");
        list.forEach((i) -> System.out.print(i + " "));
        System.out.println();

        max = max(list);
        System.out.println("Max number in array list: " + max);

        Random r = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(r.nextInt(10));
        }
        System.out.print("Random numbers with duplicates: ");
        numbers.forEach((i) -> System.out.print(i + " "));
        System.out.println();
        numbers = removeDuplicates(numbers);
        System.out.print("Random numbers without duplicates: ");
        numbers.forEach((i) -> System.out.print(i + " "));
        System.out.println();

    }

    private static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (E[] row : list) {
            for (E col : row) {
                if (col.compareTo(max) < 0) {
                    max = col;
                }
            }
        }

        return max;
    }

    private static <E> void shuffle(ArrayList<E> list) {
        Random r = new Random();
        for (int i = 0; i < list.size(); i++) {
            E item = list.get(i);
            list.remove(item);
            list.add(r.nextInt(list.size()), item);
        }
    }

    private static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);
        for (E item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    private static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E item : list) {
            if (result.indexOf(item) < 0) {
                result.add(item);
            }
        }

        return result;
    }

}

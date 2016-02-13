/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number != 0) {
            list.add(number);
            number = sc.nextInt();
        }
        ArrayList<Integer> distinct = new ArrayList<>();
        for (Integer listItem : list) {
            if (distinct.indexOf(listItem) == -1) {
                distinct.add(listItem);
            }
        }
        distinct.forEach((i)-> System.out.printf("%1s ", i));
        System.out.println();
    }

}

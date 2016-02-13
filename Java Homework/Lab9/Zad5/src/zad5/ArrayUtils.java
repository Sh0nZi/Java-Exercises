/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/**
 *
 * @author sstoyanov
 */
public class ArrayUtils {

    public static List<Integer> filterNumbers(Predicate<Integer> condition, int[] array){
        List<Integer> list = new ArrayList<>();
        fillList(list, array);
        return list.stream().filter(condition).collect(Collectors.<Integer>toList());
    }
    
    public static int[] generateRandom(int min, int max){
        Random rand = new Random();
        int[] array = new int[20];
        for(int i = 0; i< array.length; i++){
            array[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        return array;
    }
    
    private static void fillList(List<Integer> list , int[] array){
        for (int item : array) {
            list.add(item);
        }
    }
    
}

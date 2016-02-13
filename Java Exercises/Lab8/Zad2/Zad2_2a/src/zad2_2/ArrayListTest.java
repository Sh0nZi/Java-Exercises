/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author sstoyanov
 */
public class ArrayListTest {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        //2.2a
        init();
        sort();
        list.forEach((item) -> System.out.print(item + " "));
        System.out.println();
        
        //2.2b
        list.clear();
        list.add("test");
        list.add("list");
        list.add("test");
        list.add("list");
        list.add("test");
        list.add("list");
        list.add("test");
        sortByFrequiency();
        list.forEach((item) -> System.out.print(item + " "));
        System.out.println();
        
        //2.2c
        List<Integer> nums = new ArrayList<>();
        nums.clear();
        nums.add(4);
        nums.add(2);
        nums.add(3);
        nums.add(-1);
        nums.add(4);
        System.out.print("Initial collection: ");
        nums.forEach((item) -> System.out.print(item + " "));
        int max = removeMax(nums);
        System.out.println();
        System.out.println("Max number: " + max);
        System.out.print("Collection without the max number: ");
        nums.forEach((item) -> System.out.print(item + " "));
        System.out.println();
        
        //2.2d
        getNames();
        
        //2.2e
        searchNames();
        
        //2.2f
        copyTo(new ArrayList<>());
        
        //2.2g
        init();
        System.out.println(toStringDescending());
        
    }

    private static void init() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString().substring(0, 7));
        }
    }

    private static void sort() {
        list.sort((a, b) -> a.compareTo(b));
    }

    private static void sortByFrequiency() {
        Map<String, Integer> counter = new HashMap<>();
        for (String str : list) {
            counter.put(str, 1 + (counter.containsKey(str) ? counter.get(str) : 0));
        }
        list.sort((a, b) -> counter.get(a) - counter.get(b));
    }

    private static <T extends Comparable<? super T>> T removeMax(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).compareTo(max) > 1){
                max = list.get(i);
            }
            
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==max){
                list.remove(i);
            }
        }
        
        return max;
    }
    
    private static void getNames(){
        Scanner sc = new Scanner(System.in);
        
        HashSet<String> names = new HashSet<>();
        System.out.print("Enter name or \"exit\" to exit: ");
        String input = sc.next();
        
        while(!"exit".equals(input)){
            names.add(input);
            System.out.print("Enter name or \"exit\" to exit: ");
            input = sc.next();
        }
        
        System.out.println("Unique names added: ");
        names.forEach((name) -> System.out.print(name + " "));
        System.out.println();
    }
    
    private static void searchNames(){
        ArrayList<String> names = new ArrayList<>();
        names.add("ivan");
        names.add("peter");
        names.add("mitko");
        names.add("nikolay");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println(names.contains(sc.next()) ? "Name found!" : "Name not found");
    }
    
    private static void copyTo(ArrayList<String> str ){
        str = new ArrayList<>(list);
        
        System.out.println(str == list);
    }
    
    private static String toStringDescending(){
         list.sort((a, b) -> b.compareTo(a));
         return String.join(" ", list);
    }
}

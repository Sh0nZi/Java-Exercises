/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author sstoyanov
 */
public class Zad3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strArrA[] = {"dog", "cat", "tiger", "pig"},
               strArrB[] = {"frog", "dog", "monkey", "pig", "snake"}; 
        
        Set<String> result = addAll(new TreeSet<>(Arrays.asList(strArrA)), Arrays.asList(strArrB));
        
        result.forEach((i) -> System.out.print(i + " "));
        System.out.println();
    }
    
    private static <T> Set<T> addAll(Set<T> s, Collection<? extends T> c) {
        Set<T> result = new TreeSet<>(s);
        Iterator<? extends T> iter = c.iterator(); 
        while(iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author sstoyanov
 */
public class Zad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] elements = {1, 3, 4, 1, 5, 2, 3, 6, 6, 6, 4, 1, 2, 6,
            2, 3, 1, 2, 1, 5, 5, 1, 1, 5, 4};
        Map<Integer,Object> map = getMap(elements);
        Map.Entry<Integer, Object> entry = getMostFrequentlyOccuredElemens(map);
        System.out.println("The most frequent element " + entry.getKey() + 
                " occurs " + entry.getValue() + " times");

    }

    private static <T> Map<T, Object> getMap(T[] array) {
        Map<T, Object> map = new HashMap<>();
        for (T item : array) {
            if(map.get(item) == null){
                map.put(item, 0);
            }
            int count = (int)map.get(item);
            map.put(item, ++count);
        }
        return map;
    }

    private static  <T> Map.Entry<T, Object> getMostFrequentlyOccuredElemens(Map<T, Object> map) {
        Map.Entry entry = null;
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if( entry == null || (int)me.getValue() > (int)entry.getValue()){
                entry = me;
            }
        }
        return entry;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3_1;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author sstoyanov
 */
public class Zad3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeMap<String, String> map = getMap();
        System.out.println("Map size: " + map.size());
        System.out.printf("The team in Chicago is %1s.\n", map.get("Chicago"));
        map.put("San Francisco", "Niners");
        System.out.printf("The team in San francisco changed to %1s.\n", map.get("San Francisco"));
        System.out.printf("San Diego has%1s a team.\n",
                (map.containsKey("San Diego") && map.get("San Diego") != null
                && !"".equals(map.get("San Diego")) ? "" : " not"));
        map.remove("Denver");
        System.out.println("Denver has been removed from the map. Current size: " + map.size());
        map.put("Dallas", "Cowboys");
        System.out.println("Dalas with team " + map.get("Dallas")
                + " has been added to the map. Current size: " + map.size());
        for (int i = 0; i < 10; i++) {

        }
        
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if (me.getKey().toString().charAt(0) >= 'M' && me.getKey().toString().charAt(0) <= 'Z') {
                i.remove();
            }
        }

        System.out.println("Cities from M to Z removed.");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

    }

    private static TreeMap<String, String> getMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("San Francisco", "Forty-niners");
        map.put("Chicago", "Bears");
        map.put("Denver", "Broncos");
        map.put("Seattle", "Seahawks");
        map.put("Miami", "Dolphins");
        map.put("Detroit", "Lions");

        return map;
    }
}

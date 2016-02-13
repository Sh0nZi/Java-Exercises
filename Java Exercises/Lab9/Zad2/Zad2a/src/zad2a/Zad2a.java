/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2a;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author sstoyanov
 */
public class Zad2a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Zad 2a
        Consumer<Integer> intConsumer = (value) -> System.out.printf("%d ", value);
        intConsumer.accept(4);

        //Zad 2b
        String text = "hahahaha";
        String toUpperCase = toUpperCase(new UpperCase() {
            @Override
            public String toUpperCase() {
                return text.toUpperCase();
            }
        });

        System.out.println("\n" + toUpperCase);

        //Zad 2c
        Supplier<String> welcomer = () -> "Welcome to lambdas!";
        System.out.println(welcomer.get());

        //Zad 2d
        BiFunction<Integer,Integer,Integer> greater = (a, b) -> a > b ? a : b;
        
        System.out.println(greater.apply(9, 8));
    }

    public static String toUpperCase(UpperCase func) {
        return func.toUpperCase();
    }

}

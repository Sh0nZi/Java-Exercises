/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1c;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author sstoyanov
 */
public class Zad1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function<Double, Double> cos = (x) -> Math.cos(x);
        Consumer<Integer> printer = (x) -> System.out.println(x);
        Runnable sup = () -> System.out.println("Tова е Ламбда");
        BiPredicate<Integer, Integer> biPred = (x, y) -> x > y;
        Predicate<Integer> pred = (x) -> x % 2 == 0;
        BinaryOperator<Double> operator = (x, y) -> x + y;
    }
}

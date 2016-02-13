/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1a;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author sstoyanov
 */
public class Zad1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println("Number 22 is " + (isEven.test(23) ? "even." : "odd."));

        Computer fc = new Computer(2500);
        Computer sc = new Computer(2400);
        BiPredicate<Computer, Computer> areCompsEqual = (Computer a, Computer b) -> a.equals(b);
        System.out.printf(
                "Computer with %1s mhz is %2s as another computer with %3s mhz.\n",
                fc.getCpuSpeed(),
                areCompsEqual.test(fc, sc) ? "the same" : "not the same",
                sc.getCpuSpeed());

        Function<Computer, Double> getSpeed = (c) -> c.getCpuSpeed();

        System.out.println("First computer speed: " + getSpeed.apply(fc));

        Consumer<Integer> squarer = (num) -> System.out.printf("Square of %1s is %2s.\n", num, num * num);
        squarer.accept(7);
        
        Supplier<String> getComputerSpeed = () -> "Second computer speed: " + getSpeed.apply(sc);
        Consumer<String> messagePrinter = (msg) -> System.out.println(msg);
        messagePrinter.accept(getComputerSpeed.get());
        
        BinaryOperator<Integer> sum = (a, b) ->  a + b; 
        messagePrinter.accept("Sum of 375 and 649 is " + sum.apply(375, 649));

    }

}

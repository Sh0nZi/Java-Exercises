/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6;

import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.swing.JOptionPane;

/**
 *
 * @author sstoyanov
 */
public class LambdaDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Predicate<Salesperson> predicate1 = (sp) -> sp.getNumSales() > 1200;
        Predicate<Salesperson> predicate2 = (sp) -> sp.getNumSales() > 900 
                && sp.getSalary() < 2500; 
        Consumer<Salesperson> consumer1 = (sp) ->  
        { sp.addBonus(sp.getSalary() * 0.05); System.out.println(sp); };
        Consumer<Salesperson> consumer2 = (sp) ->
        { sp.addBonus(sp.getSalary() * 0.02); JOptionPane.showMessageDialog(null, sp); };
        Salesperson[] salespersons
                = {
                    new Salesperson("John Doe", 2000, 949),
                    new Salesperson("Jane Doe", 3900, 1500)
                };
        for (Salesperson salesperson : salespersons) {
            applyBonus(salesperson,
                    predicate1,
                    consumer1);
            System.out.println(salesperson);
        }
        for (Salesperson salesperson : salespersons) {
            applyBonus(salesperson,
                    predicate2,
                    consumer2);
            System.out.println(salesperson);
        }

    }

    public static void applyBonus(Salesperson salesperson,
            Predicate<Salesperson> predicate,
            Consumer<Salesperson> consumer) {
        if(predicate.test(salesperson)){
            consumer.accept(salesperson);
        }
    }

}

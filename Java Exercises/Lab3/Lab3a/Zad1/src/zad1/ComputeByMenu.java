/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class ComputeByMenu {
    private final Scanner scanner;    
    private double x;
    public ComputeByMenu() {
        this.x = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("1.	Въведи число x  в плаваща запетая");
        System.out.println("2.	Пресметни  и изведи exp(x)");
        System.out.println("3.	Пресметни  и изведи sin(x)");
        System.out.println("4.	Пресметни и изведи floor(x)");
        System.out.println("5.	Край");
    }

    public void doSelection(int choice) {
        switch (choice) {
            case 1: System.out.print("Въведете x:");
                this.x = this.scanner.nextDouble();
                break;
            case 2:
                System.out.print("Exp(x) = ");
                System.out.println(Math.exp(this.x));
                break;
            case 3:
                System.out.print("Sin(x) = ");
                 System.out.println(Math.sin(this.x));
                break;
            case 4:
                System.out.print("Floor(x) = ");
                 System.out.println(Math.floor(this.x));
                break;
            default: break;
        }
    }
    
    public void getUserChoice(){
        int userChoice = 0;
        do{
            this.displayMenu();
            System.out.print("Въведете избор: ");
            userChoice = this.scanner.nextInt();
            this.doSelection(userChoice);
        }while(userChoice != 5);
        System.out.println("До скоро!");
    }
}

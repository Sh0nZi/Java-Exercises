/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Scanner;
/**
 *
 * @author sstoyanov
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "";
        while(true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "C":
                    System.out.print("Please enter temperature in Celsius:");
                    double tempCelsius = scanner.nextDouble();
                    System.out.printf("%s%s\n",
                            "Degrees in Fahrenheit:",
                            calculateCelsiusToFahrenheit(tempCelsius));
                    break;
                case "F":
                    System.out.print("Please enter temperature in Fahrenheit:");
                    double tempFhrenheit = scanner.nextDouble();
                    System.out.printf("%s%s\n",
                            "Degrees in Celsius:",
                            calculateFahrenheitToCelsius(tempFhrenheit));
                    break;
                case "E":
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    private static double calculateFahrenheitToCelsius(double fahrenheitTemperature) {
        return 5.0 / 9.0 * (fahrenheitTemperature - 32);
    }

    private static double calculateCelsiusToFahrenheit(double celsiusTemperature) {
        return 9.0 / 5.0 * celsiusTemperature + 32;
    }

    private static void displayMenu() {
        System.out.printf("%s\n%s\n%s\n%s\n",
                "Please enter a choice:",
                "Press C for Celsius to Fahrenheit conversion",
                "Press F for Fahrenheit to Celsius conversion",
                "Press E to exist");
    }

}

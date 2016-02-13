/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad1;

/**
 *
 * @author sstoyanov
 */
public class Celsius {

    private double celsius;

    public Celsius(double celsiusDegrees) {
        setCelsius(celsiusDegrees);
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double value) {
        celsius = value;
    }
    
    public double convertToFahrenheit(){
        double fahrenheit = 9.0 / 5.0 * getCelsius() + 32;
        return fahrenheit;
    }
}

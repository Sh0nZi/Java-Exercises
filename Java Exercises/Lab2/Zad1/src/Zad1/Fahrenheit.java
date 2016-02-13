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
public class Fahrenheit {
    private double fahrenheit;
     public Fahrenheit(double fahrenheitDegrees) {
        setFahrenheit(fahrenheitDegrees);
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double value) {
        fahrenheit = value;
    }
    
    public double convertToCelsius(){
        double celsius = 5.0 / 9.0 * (getFahrenheit() - 32 );
        return celsius;
    }
}

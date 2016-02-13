/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author sstoyanov
 */
public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
        this(1, 1);
    }

    public Rational(int numerator, int denominator) {
        int commonDivisor = this.commonDivisor(numerator, denominator);
        if (commonDivisor > 1) {
            numerator /= commonDivisor;
            denominator /= commonDivisor;
        }
        this.setNumerator(numerator);
        this.setDenominator(denominator);
    }

    public Rational(Rational rat){
        this(rat.getNumerator(), rat.getDenominator());
    }
    
    public int getNumerator() {
        return this.numerator;
    }

    public final void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public final void setDenominator(int denominator) {
        if(denominator == 0){
            throw new ArithmeticException ("Division by zero is not allowed!");
        }
        this.denominator = denominator;
    }

    public Rational add(Rational rat){
        int newNumerator = this.getNumerator() * rat.getDenominator() 
                + this.getDenominator() * rat.getNumerator();
        int newDenumerator = this.getDenominator() * rat.getDenominator();
        return new Rational(newNumerator, newDenumerator);
    }
    
    public Rational subtract(Rational rat){
        int newNumerator = this.getNumerator() * rat.getDenominator() 
                - this.getDenominator() * rat.getNumerator();
        int newDenumerator = this.getDenominator() * rat.getDenominator();
        return new Rational(newNumerator, newDenumerator);
    }
    
    public Rational multiplyBy(Rational rat){
        int newNumerator = this.getNumerator() * rat.getNumerator();
        int newDenumerator = this.getDenominator() * rat.getDenominator();
        return new Rational(newNumerator, newDenumerator);
    }
    
    public Rational divideBy(Rational rat){
        int newNumerator = this.getNumerator() * rat.getDenominator();
        int newDenumerator = this.getDenominator() * rat.getNumerator();
        return new Rational(newNumerator, newDenumerator);
    }
    
    @Override
    public String toString() {
        
        return String.format(
                "%1s%2s%3s",
                (double)this.getNumerator() / this.getDenominator() < 0 ? "-" : "",
                Math.abs(this.getNumerator()), 
                Math.abs(this.getDenominator()) != 1 ? "/" +Math.abs(this.getDenominator()) : "" );

    }

    private int commonDivisor(int numerator, int denominator) {
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        for (int i = Math.max(numerator, denominator); i >= 2 ; i--) {
            if (denominator % i == 0 && numerator % i == 0) {
                return i;
            }
        }

        return 0;
    }
}

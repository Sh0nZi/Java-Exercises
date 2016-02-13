/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author sstoyanov
 */
public class Calculator {

    private final int[] numbers;
    private int count = 0;

    private int numbersCount = 0;

    public Calculator(int count) {
        this.count = count;
        numbers = new int[count];
    }

    public void generateNumbers(
            Range firstRange, Range secondRange, Range thirdRange,
            Range fourthRange, Range fifrthRange) {

        for (int i = 0; i < count; i++) {
            numbers[i] = fifrthRange.getRandomDigit();
            numbers[i] = numbers[i] + fourthRange.getRandomDigit() * 10;
            numbers[i] = numbers[i] + thirdRange.getRandomDigit() * 100;
            numbers[i] = numbers[i] + secondRange.getRandomDigit() * 1000;
            numbers[i] = numbers[i] + firstRange.getRandomDigit() * 10000;
        }
    }

    public void generateNumbers(
            Range[] ranges) {
        for (int i = 0; i < count; i++) {
            numbers[i] = ranges[4].getRandomDigit();
            numbers[i] = numbers[i] + ranges[3].getRandomDigit() * 10;
            numbers[i] = numbers[i] + ranges[2].getRandomDigit() * 100;
            numbers[i] = numbers[i] + ranges[1].getRandomDigit() * 1000;
            numbers[i] = numbers[i] + ranges[0].getRandomDigit() * 10000;
        }
    }

    public int getNumbersDividedByNumber(int number) {
        numbersCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % number == 0) {
                numbersCount++;
            }
        }

        return numbersCount;
    }

    public double getProbability() {
        return ((double) numbersCount) / count;
    }
}

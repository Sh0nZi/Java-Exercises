/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.print("Please enter a valid five-digit number: ");
            Scanner input = new Scanner(System.in);
            try {
                int number = input.nextInt();
                if (Math.floor(Math.log10(number) + 1) == 5) {
                    char[] numberAsCharArray = String.valueOf(number).toCharArray();
                    boolean isPalindrome = true;
                    for (int i = 0; i < 2; i++) {
                        if(numberAsCharArray[i] != numberAsCharArray[numberAsCharArray.length - i - 1]){
                             isPalindrome = false;
                             break;
                        }
                    }
                    System.out.printf("The number %s is %sa palindrome.\n", number, isPalindrome ? "" : "not ");
                }
            } catch (Exception ex) {
            }
        }
    }

}

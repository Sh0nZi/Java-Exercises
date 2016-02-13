/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("Please enter a valid four-digit number: ");
        Scanner input = new Scanner(System.in);
        try {
            int number = input.nextInt();
            if (Math.floor(Math.log10(number) + 1) == 4) {
                Scanner operation = new Scanner(System.in);
                System.out.print("Please enter 'encrypt' or 'decrypt' to operate:");
                     switch (operation.nextLine()) {
                    case "encrypt":
                        System.out.printf("Encrypted number: %s\n", encrypt(number));
                        break;
                    case "decrypt":
                        System.out.printf("Decrypted number: %s\n", decrypt(number));
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.print("Invalid operation.");
                        break;
                }
            }else{
                System.out.println("The number must be a four-digit one.");
            }
        } catch (Exception ex) {
            System.out.println("Invalid number.");
        }
    }

    private static void swap(char[] array, int firstPos, int secondPos) {
        char temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
    }

    private static int encrypt(int number) {
        char[] numberAsCharArray = String.valueOf(number).toCharArray();
        for (int i = 0; i < numberAsCharArray.length; i++) {
            numberAsCharArray[i] =  (char)(((numberAsCharArray[i] - '0' + 7) % 10) + '0');
            
        }
        swap(numberAsCharArray, 0, 2);
        swap(numberAsCharArray, 1, 3);
        
        return Integer.parseInt(String.valueOf(numberAsCharArray));
    }
    private static int decrypt(int number) {
        char[] numberAsCharArray = String.valueOf(number).toCharArray();
        for (int i = 0; i < numberAsCharArray.length; i++) {
            numberAsCharArray[i] =  (char)(((numberAsCharArray[i] - '0' - 7 + 10) % 10) + '0');
        }
        swap(numberAsCharArray, 0, 2);
        swap(numberAsCharArray, 1, 3);
        
        return Integer.parseInt(String.valueOf(numberAsCharArray));
    }
}

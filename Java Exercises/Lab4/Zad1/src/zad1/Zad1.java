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
        Cryptographer cr = new Cryptographer();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String t = "";
        while(true){
            System.out.println("1. To encrypt text.");
            System.out.println("2. To decrypt text.");
            System.out.println("3. To exit.");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter text to encrypt:");
                    t = sc.next();
                    System.out.printf("%1s encrypted: %2s\n", t, cr.encrypt(t));
                    break;
                case 2:
                    System.out.print("Enter text to decrypt:");
                    t = sc.next();
                    System.out.printf("%1s decrypted: %2s\n", t, cr.decrypt(t));
                    break;
                case 3: System.out.println("Goodbye!"); return;
            }
        }
    }
    
}

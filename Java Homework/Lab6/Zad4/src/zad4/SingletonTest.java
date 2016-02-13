/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

/**
 *
 * @author sstoyanov
 */
public class SingletonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton anotherInstance = Singleton.getInstance();
        System.out.println("Are the two objects refering to the same memory? " + (instance == anotherInstance));
    }
    
}

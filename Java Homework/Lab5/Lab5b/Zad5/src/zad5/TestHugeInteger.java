/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

/**
 *
 * @author sstoyanov
 */
public class TestHugeInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HugeInteger firstInt = new HugeInteger("6669");
        HugeInteger secondInt = new HugeInteger("3331");
        HugeInteger thirdInt = new HugeInteger("0");
        HugeInteger fourthInt = new HugeInteger("6669");
        
        System.out.println(firstInt.add(secondInt).toString());
        System.out.println(firstInt.add(fourthInt).toString());
        System.out.println(firstInt.substract(secondInt).toString());
        System.out.println(firstInt.isEqualTo(fourthInt));
        System.out.println(firstInt.isLessThanOrEqualTo(fourthInt));
        System.out.println(firstInt.isGreatherThan(secondInt));
        System.out.println(secondInt.isLessThan(fourthInt));
        System.out.println(thirdInt.isZero());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import zad4.OuterClassA.InnerClassA;
import zad4.OuterClassB.InnerClassB;

/**
 *
 * @author sstoyanov
 */
public class TestOuterInnerLab3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       OuterClassA oa = new OuterClassA();
       OuterClassB ob = new OuterClassB();
       InnerClassA ia = oa.new InnerClassA("IvanA");
       InnerClassB ib = ob.new InnerClassB("IvanB");
       
       System.out.println(oa);
       System.out.println(ob);
       System.out.println(ia);
       System.out.println(ib);
    }
    
}

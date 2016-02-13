/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import zad4.OuterClassA.InnerClassA;

/**
 *
 * @author sstoyanov
 */
public class OuterClassB {

    public OuterClassB() {
    }

    public class InnerClassB extends InnerClassA {

        public InnerClassB(){
            this("Alabala");
        }
        
       public InnerClassB(String s){
           new OuterClassA().super(s);
       }
    }

    public InnerClassB getInnerClassB(OuterClassA oa, String s) {
        return new InnerClassB(s); 
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

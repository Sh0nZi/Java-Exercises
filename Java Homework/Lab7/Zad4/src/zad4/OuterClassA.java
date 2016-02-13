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
public class OuterClassA {

    public OuterClassA() {
    }

    public class InnerClassA {

        private String myName;

        public InnerClassA(){}
        
        public InnerClassA(String myName) {
            this.myName = myName;
        }

        public String getMyName() {
            return this.myName;
        }

        public void setMyName(String myName) {
            this.myName = myName;
        }

        @Override
        public String toString() {
            return this.getClass().getName() + " " + this.getMyName();
        }
    }

    public InnerClassA getInnerClassA(String s) {
        return new InnerClassA(s);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

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
public class Sequence {

    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }

    public void add(Object x) {
        if (next < obs.length) {
            obs[next] = x;
            next++;
        }
    }

    private class Sselector implements Selector {

        int i = 0;

        @Override
        public boolean end() {
            return i == obs.length;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if (i < obs.length) {
                i++;
            }
        }
    } 

    private class Rselector implements Selector {

        int i = obs.length - 1;

        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }
    
    public Selector getSelector() {
        return new Sselector();
    }
    
    public Selector getRSelector(){
        return new Rselector();
    }

}

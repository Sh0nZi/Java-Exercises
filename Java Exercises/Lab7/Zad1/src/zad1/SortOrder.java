/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author sstoyanov
 */
public class SortOrder {

    private class Upward implements Sortable {

        @Override
        public boolean greater(int a, int b) {
            return a > b;
        }

    }

    private class Downward implements Sortable {

        @Override
        public boolean greater(int a, int b) {
            return a < b;
        }

    }

    public Sortable ascending() {
        return new Upward();
    }

    public Sortable descending() {
        return new Downward();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad2;

/**
 *
 * @author sstoyanov
 */
public class Point {

    private final int[] coordinates;

    public Point(){
        this.coordinates = new int[2];
    }
    
    public Point(int x, int y) {
        coordinates = new int[]{x, y};
    }

    public Point(Point point){
        this.coordinates = new int[]{ point.getX(), point.getY() };
    }
    
    public int getX() {
        return coordinates[0];
    }

    public void setX(int x) {
        coordinates[0] = x;
    }

    public int getY() {
        return coordinates[1];
    }

    public void setY(int y) {
        coordinates[1] = y;
    }
    
    @Override
    public String toString(){
        return String.format("(%1s, %2s)", this.getX(), this.getY());
    }
}

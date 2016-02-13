/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author sstoyanov
 */
public class Cylinder extends Circle {

    private int h;

    public Cylinder(int x, int y, int r, int h) {
        super(x, y, r);
        this.h = h;
    }

    public int getH() {
        return this.h;
    }

    @Override
    public boolean greater(IComparable obj) {
        Cylinder c = (Cylinder) obj;
        if (c == null) {
            throw new RuntimeException("Invalid object. Cylinder expected");
        }
        if (super.greater(obj)) {
            return true;
        } else if (this.getX() == c.getX() && this.getY() == c.getY() && this.getR() == c.getR()) {
            return this.getH() > c.getH();
        }

        return false;
    }
    
    @Override 
    public String toString(){
        return String.format("(%1s, %2s)", super.toString(), this.getH());
    }

}

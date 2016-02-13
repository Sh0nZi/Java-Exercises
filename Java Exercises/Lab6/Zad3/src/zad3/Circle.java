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
public class Circle extends Point {

    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }
    
    public int getR(){
        return this.r;
    }
    
    @Override
    public boolean greater(IComparable obj){
        Circle c = (Circle)obj;
        if(c == null){
            throw new RuntimeException("Invalid object. Circle expected");
        }
        if(super.greater(obj)){
            return true;
        }else if(this.getX() == c.getX() && this.getY() == c.getY()){
            return this.getR() > c.getR();
        }
        
        return false;
    }
    
    @Override 
    public String toString(){
        return String.format("(%1s, %2s)", super.toString(), this.getR());
    }
}

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
public class Point implements IComparable{
    private int x;
    private int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    @Override
    public boolean greater(IComparable obj) {
        Point pt = (Point)obj;
        if(pt == null){
            throw new RuntimeException("Invalid object. Point expected");
        }
        if(this.getX() > pt.getX()){
            return true;
        }else if(this.getX() == pt.getX()){
            return this.getY() > pt.getY();
        }
        
        return false;
    }
    
    @Override
    public String toString(){
        return String.format("(%1s, %2s)", this.getX(), this.getY());
    }
}

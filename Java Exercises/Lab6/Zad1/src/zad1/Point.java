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
public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Point(){
        this(0, 0);
    }
    
    public Point(Point pt){
        this(pt.getX(), pt.getY());
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public Point getPoint(){
        return this;
    }
    
    public void setPoint(Point pt){
        this.setX(pt.getX());
        this.setY(pt.getY());
    }
    
    @Override
    public String toString(){
        return String.format("(%1s, %2s)", this.getX(), this.getY());
    }
}

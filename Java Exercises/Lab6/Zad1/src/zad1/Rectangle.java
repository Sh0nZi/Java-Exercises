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
public class Rectangle extends Point{
    
    private Point lowerRight;
    
    public Rectangle(){
        this(new Point(), new Point(100, 50));
    }
    
    public Rectangle(Point upperLeft, Point lowerRight){
        super(upperLeft);
        this.lowerRight = lowerRight;
    }
    
    public Rectangle(Rectangle rect){
        this.setPoint(rect.getPoint());
        this.setLowerRight(rect.getLowerRight());
    }
    
    public Point getLowerRight(){
        return this.lowerRight;
    }
    
    public final void setLowerRight(Point pt){
        this.lowerRight = pt;
    }
    
    public double measure(){
        return 2 * (this.getLowerRight().getX() - this.getPoint().getX()) 
                + 2 * (this.getLowerRight().getY() - this.getPoint().getY());
    }
    
    @Override
    public String toString(){
        return String.format("(%1s, %2s)", super.toString(), this.getLowerRight());
    }
}

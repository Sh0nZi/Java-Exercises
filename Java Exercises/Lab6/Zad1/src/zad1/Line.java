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
public class Line {
    private Point sPoint;
    private Point ePoint;
    
    public Line(Point sPoint, Point ePoint){
        this.sPoint = sPoint;
        this.ePoint = ePoint;
    }
    
    public Line(){
        this(new Point(), new Point());
    }
    
    public Line(Line line){
        this(line.getSPoint(), line.getEPoint());
    }
    
    public Point getSPoint(){
        return this.sPoint;
    }
    
    public void setSPoint(Point sPoint){
        this.sPoint = sPoint;
    }
    
    public Point getEPoint(){
        return this.ePoint;
    }
    
    public void setEPoint(Point ePoint){
        this.ePoint = ePoint;
    }
    
    public double measure(){
        return Math.sqrt(
                (this.getEPoint().getY() - this.getSPoint().getY()) *
               (this.getEPoint().getY() - this.getSPoint().getY()) +
               (this.getEPoint().getX() - this.getSPoint().getX()) *
               (this.getEPoint().getX() - this.getSPoint().getX()));
    }
    
    @Override
    public String toString(){
        return String.format("(%1s, %2s)", this.getSPoint(), this.getEPoint());
    }
}

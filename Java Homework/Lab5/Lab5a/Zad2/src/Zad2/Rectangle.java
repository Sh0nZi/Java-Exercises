/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad2;

import java.awt.*;

/**
 *
 * @author sstoyanov
 */
public class Rectangle {

    private final Point[] points;

    public Rectangle() {
        this.points = new Point[2];
    }

    public Rectangle(Point uPoint, Point lPoint) {
        points = new Point[]{uPoint, lPoint};
    }

    public Rectangle(Rectangle point) {
        this(point.getUPoint(), point.getLPoint());
    }

    public Point getUPoint() {
        return points[0];
    }

    public void setUPoint(Point uPoint) {
        points[0] = uPoint;
    }

    public Point getLPoint() {
        return points[1];
    }

    public void setLPoint(Point lPoint) {
        points[1] = lPoint;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        
        g.drawRect(this.getUPoint().getX(), this.getUPoint().getY(),
                this.getLPoint().getX() - this.getUPoint().getX(),
                this.getLPoint().getY() - this.getUPoint().getY());
    }

    @Override
    public String toString() {
        return String.format(
                "Rectangle(Upper Left%1s, Lower Right%2s)",
                this.getClass().getEnclosingClass().getName(),
                this.getUPoint().toString(),
                this.getLPoint().toString());
    }
}

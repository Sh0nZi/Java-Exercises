/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sstoyanov
 */
public class Line {
     private final Point[] points;

    public Line() {
        this.points = new Point[2];
    }

    public Line(Point sPoint, Point ePoint) {
        points = new Point[]{sPoint, ePoint};
    }

    public Line(Line line) {
        this.points = new Point[]{line.getSPoint(), line.getEPoint()};
    }

    public Point getSPoint() {
        return points[0];
    }

    public void setSPoint(Point sPoint) {
        points[0] = sPoint;
    }

    public Point getEPoint() {
        return points[1];
    }

    public void setEPoint(Point ePoint) {
        points[1] = ePoint;
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.drawLine(
                this.getSPoint().getX(),
                this.getSPoint().getY(),
                this.getEPoint().getX(),
                this.getEPoint().getY());
    }

    @Override
    public String toString() {
        return String.format(
                "%1s(Start%2s, E%3s)",
                this.getClass().getEnclosingClass().getName(),
                this.getSPoint().toString(),
                this.getEPoint().toString());
    }
}

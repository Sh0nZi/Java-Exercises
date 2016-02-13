/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import javax.swing.JOptionPane;

/**
 *
 * @author sstoyanov
 */
public class Rectangle {

    private double width;
    private double heigth;
    private String color;

    public Rectangle(double width, double heigth, String color) {
        setWidth(width);
        setHeigth(heigth);
        setColor(color);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        if (value <= 0) {
            JOptionPane.showMessageDialog(null, "Rectangle's width should be a positive number");
        }
        width = value;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double value) {
        if (value <= 0) {
            JOptionPane.showMessageDialog(null, "Rectangle's heigth should be a positive number");
        }
        heigth = value;
    }
    
     public String getColor() {
        return color;
    }

    public void setColor(String value) {
        if (value == null || "".equals(value)) {
            JOptionPane.showMessageDialog(null, "Rectangle's color should not be a null or empty");
        }
        color = value;
    }
    
    public double getArea(){
        return getWidth() * getHeigth();
    }
    
    public double getPerimeter(){
        return (getWidth() + getHeigth()) * 2;
    }
}

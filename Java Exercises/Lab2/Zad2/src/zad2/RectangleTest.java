/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import javax.swing.*;

/**
 *
 * @author sstoyanov
 */
public class RectangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JTextField wField = new JTextField(10);
        JTextField hField = new JTextField(10);
        JTextField color = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Width:"));
        myPanel.add(wField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Heigth:"));
        myPanel.add(hField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Color:"));
        myPanel.add(color);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Width, Heigth and color", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            double width = Double.parseDouble(wField.getText());
            double heigth = Double.parseDouble(hField.getText());
            Rectangle rectangle = new Rectangle(width,heigth,color.getText());
            
            String output = String.format(
                    "Rectangle:\nColor: %s\nWidth %.2f C\nHeigth: %s.2f\nArea: %.2f\nPerimeter: %.2f\n",
                    rectangle.getColor(),
                    rectangle.getWidth(),
                    rectangle.getHeigth(),
                    rectangle.getArea(),
                    rectangle.getPerimeter());
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
}

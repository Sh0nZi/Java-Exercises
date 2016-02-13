/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zad1;

import javax.swing.*;

/**
 *
 * @author sstoyanov
 */
public class TestConvert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JTextField cField = new JTextField(10);
        JTextField fField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("C:"));
        myPanel.add(cField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("F:"));
        myPanel.add(fField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter C and F degrees", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            double celsiusDegrees = Double.parseDouble(cField.getText());
            Celsius celsiusCalculator = new Celsius(celsiusDegrees);

            double fahrenheitDegrees = Double.parseDouble(fField.getText());
            Fahrenheit fahrenheitCalculator = new Fahrenheit(fahrenheitDegrees);
            String output = String.format("Conversion:\n %.2f C = %.2f F\n%.2f F = %.2f C\n",
                    celsiusDegrees, celsiusCalculator.convertToFahrenheit(),
                    fahrenheitDegrees, fahrenheitCalculator.convertToCelsius());
            JOptionPane.showMessageDialog(null, output);
        }
    }

}

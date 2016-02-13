/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sstoyanov
 */
public class CalculatorTest {

    private static JPanel myPanel = new JPanel(new GridLayout(0,1));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame main = new JFrame("Calculator ");
        
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setContentPane(myPanel);
         
        JTextField firstL = new JTextField(5);
        addToPanel("First digit lower:", firstL, "3");
        JTextField firstU = new JTextField(5);
        addToPanel("First digit upper :", firstU, "9");
        JTextField secondL = new JTextField(5);
        addToPanel("Second digit lower :", secondL, "2");
        JTextField secondU = new JTextField(5);
        addToPanel("Second digit upper :", secondU, "8");
        JTextField thirdL = new JTextField(5);
        addToPanel("Third digit lower :", thirdL, "4");
        JTextField thirdU = new JTextField(5);
        addToPanel("Third digit upper :", thirdU, "9");
        JTextField fourthL = new JTextField(5);
        addToPanel("Fourth digit lower :", fourthL, "1");
        JTextField fourtU = new JTextField(5);
        addToPanel("Fourth digit upper :", fourtU, "6");
        JTextField fifrthL = new JTextField(5);
        addToPanel("Fifth digit lower :", fifrthL, "6");
        JTextField fifrthU = new JTextField(5);
        addToPanel("Fifth digit upper :", fifrthU, "9");
        JTextField divider = new JTextField(5);
        addToPanel("Divider :", divider, "12");
        JTextField result = new JTextField(10);
        addToPanel("Result :", result, "");
        JButton calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener((ActionEvent e) -> {
          
            Range[] ranges = new Range[5];
            int fl = Integer.parseInt(firstL.getText());
            int fu = Integer.parseInt(firstU.getText());
            int sl = Integer.parseInt(secondL.getText());
            int su = Integer.parseInt(secondU.getText());
            int tl = Integer.parseInt(thirdL.getText());
            int tu = Integer.parseInt(thirdU.getText());
            int fol = Integer.parseInt(fourthL.getText());
            int fou = Integer.parseInt(fourtU.getText());
            int fil = Integer.parseInt(fifrthL.getText());
            int fiu = Integer.parseInt(fifrthU.getText());
            ranges[4] = new Range(fl, fu);
            ranges[3] = new Range(sl, su);
            ranges[2] = new Range(tl, tu);
            ranges[1] = new Range(fol, fou);
            ranges[0] = new Range(fil, fiu);
            int c = 20;
            Calculator calc = new Calculator(c);
            calc.generateNumbers(ranges);
            int count = calc.getNumbersDividedByNumber(Integer.parseInt(divider.getText()));
            double probability = calc.getProbability();
            NumberFormat defaultFormat = NumberFormat.getPercentInstance();
            defaultFormat.setMaximumFractionDigits(2);
            String output = String.format("Total numbers: %s // Divisable: %s  // Probability: %s", c, count, defaultFormat.format(probability));
            result.setText(output);
        });
        myPanel.add(calculateBtn);
        main.pack();
        main.setVisible(true);
    }
    private static void addToPanel(String string, JTextField field, String defaultValue){
        myPanel.add(new JLabel(string));
        field.setText(defaultValue);
        myPanel.add(field);
    }
    
}

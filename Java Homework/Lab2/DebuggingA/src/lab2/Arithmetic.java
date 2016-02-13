/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import javax.swing.JOptionPane;

/**
 *
 * @author sstoyanov
 */
//   Debugging Problem /

public class Arithmetic {

    
   public static void main( String args[] )
   {
      String firstNumber, secondNumber, thirdNumber;  
      int num1, num2, num3, sum, product, average;

      firstNumber =  JOptionPane.showInputDialog( "Enter first integer:" );

      secondNumber =  JOptionPane.showInputDialog( "Enter second integer:" );
      
      thirdNumber = JOptionPane.showInputDialog( "Enter third integer:" );
  
      num1 = Integer.parseInt( firstNumber );
      num2 = Integer.parseInt( secondNumber );
      num3 = Integer.parseInt( thirdNumber );
      
      sum = num1 + num2 + num3;
      product = num1 * num2 * num3;
      average = ( num1 + num2 + num3 ) / 3;
      
      JOptionPane.showMessageDialog( null, "The sum is " + sum + 
         "\nThe product is " + product +  "\nThe average is " + average, 
         "Results", JOptionPane.PLAIN_MESSAGE );
   }

} // end class Arithmetic


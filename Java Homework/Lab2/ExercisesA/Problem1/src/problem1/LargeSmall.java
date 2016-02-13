
// Calculates the largest and smallest
// of five integers entered one at a time.

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class LargeSmall  {

   // Compute the smallest and the largest among 4 input numbers
   // obtain numerical input and determine results

   public static void main(String[] args)
   {
      String dataString;   // output string
      String smallString;  // smallest number string
      String largeString;  // largest number string
      String input;     // string entered by user
      int largest, smallest; // largest and smallest integers

      // variables to store integers input by user
      int firstNumber, secondNumber, thirdNumber,
         fourthNumber, fifthNumber;


      input = JOptionPane.showInputDialog("Enter first number :" );
      firstNumber = Integer.parseInt( input );
      
      input = JOptionPane.showInputDialog("Enter second number :" );
      secondNumber = Integer.parseInt( input );

      largest = Math.max(firstNumber, secondNumber);
      smallest = Math.min(firstNumber, secondNumber);
      
      input = JOptionPane.showInputDialog("Enter third number :" );
      thirdNumber = Integer.parseInt( input );

      largest = Math.max(largest, thirdNumber);
      smallest = Math.min(smallest, thirdNumber);
        
      input = JOptionPane.showInputDialog("Enter fourth number :" );
      fourthNumber = Integer.parseInt( input );

      largest = Math.max(largest, fourthNumber);
      smallest = Math.min(smallest, fourthNumber);
      
      input = JOptionPane.showInputDialog("Enter fifth number :" );
      fifthNumber = Integer.parseInt( input );

      largest = Math.max(largest, fifthNumber);
      smallest = Math.min(smallest, fifthNumber);
      
      String result = String.format(
                      "The largest number is: %1s\n The smallest number is %2s",
                      largest, smallest);
      JOptionPane.showMessageDialog(null, result);
 
   } // end method main
   
}// end class LargeSmall


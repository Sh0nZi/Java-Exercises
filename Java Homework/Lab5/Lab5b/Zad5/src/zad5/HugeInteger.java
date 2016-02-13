/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

import java.util.Arrays;

/**
 *
 * @author sstoyanov
 */
public class HugeInteger {
    private int[] digits;
    private String number;
    
    public HugeInteger(int[] digits){
        this.digits = digits;
        this.number = Arrays.toString(digits);
    }
    
    public HugeInteger(String number){
        if(number.length()> 40){
            throw new IllegalArgumentException(
                    "Number length should not be greater than 40 digits");
        }
        this.digits = new int[40];
        String[] digitsAsStr = number.split("");
        
        for (int i = 1; i <= digitsAsStr.length; i++) {
            digits[digits.length - i] = Integer.parseInt(digitsAsStr[digitsAsStr.length - i]);
        }
    }
    
    public int[] getNumber(){
     return this.digits;
    }
    
    public HugeInteger add(HugeInteger number){
        int[] firstArray = this.getNumber();
        int[] secondArray = number.getNumber();
        int[] sum = new int[firstArray.length];
        int remainder = 0;
        for (int length = firstArray.length-1; length >= 0; length--)
        {
            //Fill the array with digit: the remainder of the sum between the sum of the both numbers and the previous remainder.
            sum[length] = ((firstArray[length] + secondArray[length])+remainder)%10; 
            //Keep the remainder to be added to the next digit.
            remainder = ((firstArray[length] + secondArray[length]) + remainder) / 10;
        }
        sum[0] += remainder;
        return new HugeInteger(sum);
    }
    
     public HugeInteger substract(HugeInteger number){
        int[] firstArray = this.getNumber();
        int[] secondArray = number.getNumber();
        int[] result = new int[firstArray.length];
        for (int length = firstArray.length-1; length >= 0; length--)
        {
            if(firstArray[length] >=  secondArray[length]){
                result[length] = firstArray[length] - secondArray[length];
            }
            else{
                for (int i = length - 1; i >= 0; i--) {
                    if(firstArray[i] != 0){
                        firstArray[i]--;
                        result[length] = 10 + firstArray[length] - secondArray[length]; 
                    }
                }
            }
        }
        return new HugeInteger(result);
    }
     
     public boolean isEqualTo(HugeInteger number){
         for (int i = 0; i < this.digits.length; i++) {
             if(number.getNumber()[i]!=this.digits[i]){
                 return false;
             }
         }
         return true;
     }
     
     public boolean isNotEqualTo(HugeInteger number){
         return !this.isEqualTo(number);
     }
     
     public boolean isGreatherThan(HugeInteger number){
         for (int i = 0; i < this.digits.length; i++) {
             if(this.digits[i] < number.getNumber()[i]){
                 return false;
             }else if(this.digits[i] > number.getNumber()[i]){
                 return true;
             }
         }
         return false;
     }
     
     public boolean isGreatherThanOrEqualTo(HugeInteger number){
         return this.isGreatherThan(number) || this.isEqualTo(number);
     }
     
     public boolean isLessThan(HugeInteger number){
         return !this.isGreatherThan(number) && this.isNotEqualTo(number);
     }
    
     public boolean isLessThanOrEqualTo(HugeInteger number){
         return this.isLessThan(number) || this.isEqualTo(number);
     }
     
     public boolean isZero(){
         for (int i = 0; i < this.digits.length; i++) {
             if(this.digits[i] != 0){
                 return false;
             }
         }
         return true;
     }
     
    @Override
    public String toString(){
        return this.number.replaceFirst("^0+(?!$)", "");
    }
}

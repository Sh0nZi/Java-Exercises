/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.UUID;
/**
 *
 * @author sstoyanov
 */
public class CsavingsAccount {
    private static double mAnnualInterestRate = 10;
    private double mSavingBalance;
    private String mNumber;
    
    public CsavingsAccount(){
        this(500);
    }
    
    public CsavingsAccount(double mSavingBalance){
        mNumber = UUID.randomUUID().toString();
        this.setBalance(mSavingBalance);
    }
    
    
    public CsavingsAccount(CsavingsAccount acc){
        this(acc.getBalance());
    }
    
    public double getBalance(){
        return this.mSavingBalance;
    }
    
    public final void setBalance(double balance){
        this.mSavingBalance = balance;
    }
    
    public static void modifyInterestRate(double newAnnualInterestRate){
        mAnnualInterestRate = newAnnualInterestRate;
    }
    
    public double cualculateMonthlyInterest(){
       double newBalance = this.getBalance() * (mAnnualInterestRate / 100) / 12;
       return newBalance;
    }
    
    @Override
    public String toString(){
       return String.format("Balance: $%1.2f\n Monthly interest: $%2.2f",
               this.getBalance(), this.cualculateMonthlyInterest()); 
    }
}

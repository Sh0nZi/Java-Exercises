/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

/**
 *
 * @author sstoyanov
 */
public enum Months {

    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"), 
    JUN("June"),
    JUL("July"),
    AUG("August"), 
    SEP("September"), 
    OCT("October"), 
    NOV("November"), 
    DEC("December");

    private final String name;
    private Months(String s){
        this.name = s;
    }
    
    public static Months[] Month = new Months[]
    {
        Months.JAN,
        Months.FEB,
        Months.MAR,
        Months.APR,
        Months.MAY,
        Months.JUN,
        Months.JUL,
        Months.AUG,
        Months.SEP,
        Months.OCT,
        Months.NOV,
        Months.DEC
    };
    
    @Override
    public String toString(){
        return this.name;
    }

}

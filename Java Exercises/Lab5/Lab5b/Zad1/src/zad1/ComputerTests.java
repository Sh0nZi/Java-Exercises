/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author sstoyanov
 */
public class ComputerTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Computer firstComputer = new Computer();
        
        Computer secondComputer = new Computer(firstComputer);
        secondComputer.setType("Dell");
        secondComputer.setFiles(new String[] { "stuff.dll", "system.dll" });
        
        System.out.println(firstComputer.getType());
        System.out.println(firstComputer);
        
        System.out.println(secondComputer);
        
        Computer thirdComputer = new Computer("Sony", 3.5, new String[] { "cmd.exe"});
        System.out.println(thirdComputer);
        
        try{
            thirdComputer.setProcSpeed(-4);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        
        //The following line throws an exception
        //Computer lastComputer = new Computer("Wrong", 2, new String[]{ "test.test", "" });
    }
    
}

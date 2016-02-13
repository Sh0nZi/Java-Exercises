/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_client;

/**
 *
 * @author sstoyanov
 */
public class Zad1_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client( "127.0.0.1" );
        client.runClient();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenization;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author sstoyanov
 */
public class RegisterTokenizationServer {

    public static void main(String[] args) {
        try {
            TokenizationServerInterface obj = new TokenizationServer();
            Registry registry = LocateRegistry.createRegistry(1300);
            registry.rebind("TokenizationServer", obj);
            System.out.println("Tokenization server " + obj + " registered");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

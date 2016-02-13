/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenization;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author sstoyanov
 */
public interface TokenizationServerInterface extends Remote {

    String login(String username, String password) throws RemoteException;

    String saveToken(String cardNumber) throws RemoteException;

    String getCardNumber(String token) throws RemoteException;
}

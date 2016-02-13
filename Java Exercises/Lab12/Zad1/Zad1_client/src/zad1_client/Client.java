/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_client;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sstoyanov
 */
public class Client {

    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String message = ""; // message from server
    private String chatServer; // host server for this application
    private Socket client; // socket to communicate with server

    public Client(String host) {
        this.chatServer = host;
    }

    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } // end try
        catch (EOFException eofException) {
            System.out.println("Client terminated connection");
        } // end catch
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
        finally {
            closeConnection(); // close connection
        } // end finally
    }

    private void connectToServer() throws IOException {
        System.out.println("Attemptin connection");
        client = new Socket(InetAddress.getByName(this.chatServer), 12345);
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();

        input = new ObjectInputStream(client.getInputStream());
    }

    private void processConnection() throws IOException {
        while (true) {
            try {
                Object data = input.readObject();
                processDataFromServer(data);
                Scanner sc = new Scanner(System.in);
                sendData(sc.nextLine());

            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("\nUnknown object type received");
            }
        }
    }

    private void closeConnection() {
        System.out.println("Closing connection");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } // end try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
    }

    private void sendData(String message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException ioException) {
            System.out.println("Error writing object");
        }
    }

    private void processDataFromServer(Object data) {
        
        String msg = (String) data;
        if (msg != null) {
            System.out.println(msg);
        } else {
            try {
                ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("result.pdf"));
                ous.writeObject(data);
                sendData("File downloaded");
                System.out.println("File downloaded");
            } catch (IOException ex) {

            }
        }
    }
}

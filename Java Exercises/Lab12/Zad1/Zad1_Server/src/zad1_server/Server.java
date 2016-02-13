/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_server;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author sstoyanov
 */
public class Server {

    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private int counter = 1; // counter of number of connections
    private String password = "test123";

    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } finally {
                    closeConnection(); //  close connection
                    counter++;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection");
        connection = server.accept(); // allow server to accept connection            
        System.out.println("Connection " + counter + " received from: "
                + connection.getInetAddress().getHostName());
    } // end method waitForConnection

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());
    } // end method getStreams

    // process connection with client
    private void processConnection() throws IOException {
        String message = "Connection successful. Please enter a password.";
        sendData(message); // send connection successful message
        System.out.println("Connection successfull. Waiting for password.");
        // enable enterField so server user can send messages

        while (true) // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                if (message.equals("TERMINATE")) {
                    break;
                }

                if (!message.equalsIgnoreCase(this.password)) {
                    sendData("Wrong password. Please enter valid password.");
                    System.out.println("Client entered invalid password. Waiting for a valid password.");
                } else {
                    sendData("Downloading file.");
                    sendFile();
                    System.out.println("Downloading file.");
                }
            } // end try
            catch (ClassNotFoundException classNotFoundException) {
                System.out.println("\nUnknown object type received");
            } // end catch

        }
    } // end method processConnection

    // close streams and socket
    private void closeConnection() {
        System.out.println("\nTerminating connection\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } // end try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
    } // end method closeConnection

    // send message to client
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject(message);
            output.flush(); // flush output to client
        } // end try
        catch (IOException ioException) {
            System.out.println("Error writing object");
        } // end catch
    } // end method sendData

    private void sendFile() throws ClassNotFoundException {
        try {
            Path p = FileSystems.getDefault().getPath("", "server_file.txt");
            byte[] fileData = Files.readAllBytes(p);

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(fileData);
            output.writeObject(bs.toByteArray());
            output.flush();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
        }
    }

}

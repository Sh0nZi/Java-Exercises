/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sstoyanov
 */
public class TokenizationServer extends UnicastRemoteObject implements TokenizationServerInterface {

    private final XStream xstream;
    private User currentUser;

    public TokenizationServer() throws RemoteException {
        xstream = new XStream(new StaxDriver());
        xstream.alias("user", User.class);
        xstream.alias("card", Card.class);
        xstream.alias("right", UserRights.class);
        this.seedUsers();
    }

    @Override
    public String login(String username, String password) throws RemoteException {
        String xml = readFile("users.xml");
        List<User> users = (List<User>) xstream.fromXML(xml);

        for (User u : users) {
            if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
                currentUser = u;
                return u.getUsername();
            }
        }

        return "Invalid username and/or password.";
    }

    @Override
    public String saveToken(String cardNumber) throws RemoteException {
        if (!currentUser.hasRight(UserRights.All) && !currentUser.hasRight(UserRights.RegisterToken)) {
            return "Insufficient rights!";
        }

        if (!luhnValid(cardNumber)) {
            return "Invalid card number";
        }

        List<Card> cards;
        if (Files.exists(Paths.get("cards.xml"))) {
            String xml = readFile("cards.xml");
            cards = (List<Card>) xstream.fromXML(xml);
        } else {
            cards = new ArrayList<>();
        }

        Card card = new Card(cardNumber);
        this.registerToken(card, cards);

        cards.add(card);
        String xml = xstream.toXML(cards);
        saveFile(xml, "cards.xml");

        return "Successfully registered a card with token: " + card.getToken();
    }

    @Override
    public String getCardNumber(String token) throws RemoteException {
        if (!currentUser.hasRight(UserRights.All) && !currentUser.hasRight(UserRights.GetCard)) {
            return "Insufficient rights!";
        }

        String xml = readFile("cards.xml");
        List<Card> cards = (List<Card>) xstream.fromXML(xml);

        for (Card c : cards) {
            if (c.getToken().equals(token)) {
                return "Found a card with number: " + c.getNumber();
            }
        }

        return "Such token is not registered";
    }

    public static void main(String args[]) throws RemoteException {
        TokenizationServer server = new TokenizationServer();
        JFrame fr = new JFrame();
        JPanel pnlButton = new JPanel();
        JButton orderByToken = new JButton("Get cards info ordered by token");
        JButton orderByNumber = new JButton("Get cards info ordered by number");
        orderByToken.setSize(100, 50);
        orderByToken.setLayout(null);
        orderByToken.addActionListener(e -> {
            try {
                server.getCardInfo(SortBy.Token);
            } catch (RemoteException ex) {
            }
        });
        orderByNumber.setSize(100, 50);
        orderByNumber.setLayout(null);
        orderByNumber.addActionListener(e -> {
            try {
                server.getCardInfo(SortBy.CardNumber);
            } catch (RemoteException ex) {
            }
        });
        pnlButton.add(orderByToken);
        pnlButton.add(orderByNumber);
        fr.add(pnlButton);
        fr.setSize(500, 80);
        fr.setTitle("Get cards info");
        fr.setVisible(true);
    }

    private String getCardInfo(SortBy sortBy) throws RemoteException {
        String xml = readFile("cards.xml");
        List<Card> cards = (List<Card>) xstream.fromXML(xml);

        Collections.sort(cards, (a, b)
                -> sortBy == SortBy.CardNumber ? a.getNumber().compareTo(b.getNumber())
                        : a.getToken().compareTo(b.getToken()));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %s\n", "Card number:", "Token: "));
        for (Card c : cards) {
            sb.append(c).append("\n");
        }
        String fileName = String.format("sorted_by_%1s.txt", sortBy);
        saveFile(sb.toString(), fileName);
        return String.format("File '%1s' successfully saved", fileName);
    }

    private void seedUsers() {
        if (Files.exists(Paths.get("users.xml"))) {
            return;
        }

        List<User> users = new ArrayList<>();

        users.add(new User("admin", "12345", new UserRights[]{UserRights.All}));
        users.add(new User("writer", "12345", new UserRights[]{UserRights.RegisterToken}));
        users.add(new User("reader", "12345", new UserRights[]{UserRights.GetCard}));
        String xml = xstream.toXML(users);
        saveFile(xml, "users.xml");
    }

    private void registerToken(Card card, List<Card> cards) {
        Object[] usedTokens = cards.stream().map(i -> i.getToken()).toArray();
        Random rand = new Random();
        StringBuilder token = new StringBuilder();
        int index = 0;
        while (true) {

            int current = 0;
            do {
                current = rand.nextInt(10);
            } while (current == card.getNumber().charAt(index) - '0'
                    || (index == 0 ? current < 3 || current > 6 : false));
            token.append(current);
            index++;

            if (token.length() == 12) {
                if (token.chars().map(i -> i - '0').sum() % 10 != 0 || Arrays.asList(usedTokens).contains(token)) {
                    break;
                }
                token = new StringBuilder();
                index = 0;
            }
        }

        token.append(card.getNumber().substring(12));
        card.setToken(token.toString());
    }

    private boolean luhnValid(String cardNumber) {
        int digitsSum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            char ch = cardNumber.charAt(i);
            if (Character.isDigit(ch)) {
                if (i % 2 == 0) {
                    int num = (ch - '0') * 2;
                    digitsSum += (num % 10) + (num / 10);
                } else {
                    digitsSum += ch - '0';
                }
            }
        }

        return digitsSum % 10 == 0;
    }

    private void saveFile(String text, String fileName) {
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(fileName, false), Charset.forName("UTF-8"));
            w.write(text);
            w.flush();
        } catch (IOException ex) {

        }
    }

    private String readFile(String fileName) {
        Path file = Paths.get(fileName);

        try {
            return Files.readAllLines(file).stream().reduce("", (a, b) -> a + b);
        } catch (IOException ex) {
        }

        return null;
    }

}

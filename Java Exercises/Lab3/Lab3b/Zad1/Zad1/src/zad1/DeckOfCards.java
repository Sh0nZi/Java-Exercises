package zad1;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {

    private Card deck[]; // array of Card objects
    private String faces[] ;
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private final int NUMBER_OF_CARDS_HAND = 5; // constant number of Cards
    private Random randomNumbers; // random number generator
    
    private Card hand[];

    // constructor fills deck of Cards
    public DeckOfCards() {
        faces = new String[]{"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

        hand = new Card[NUMBER_OF_CARDS_HAND];
        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count]
                    = new Card(faces[count % 13], suits[count / 13]);
        }
    } // end DeckOfCards constructor

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51 
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        } // end for
    } // end method shuffle

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            hand[currentCard] = deck[currentCard];
            return deck[currentCard++]; // return current Card in array
        } else {
            return null; // return null to indicate that all Cards were dealt
        }
    } // end method dealCard\

    public String handPower() {

        if (this.isFlush() && this.consequitiveCount() > 4) {
            if (this.consequitiveCount() == 5) {
                return "Royal flush!";
            } else {
                return "Straight flush!";
            }
        }

        if (this.isFlush()) {
            return "Flush!";
        }

        if (this.consequitiveCount() > 4) {
            return "Straight!";
        }
        int[] total = this.totalHand();
        int firstSame = 1;
        int secondSame = 1;
        for (int i = 0; i < total.length; i++) {
            if (total[i] > 1) {
                if (firstSame == 1) {
                    firstSame = total[i];
                } else {
                    secondSame = total[i];
                }

            }

            if (total[i] > 1) {
            }
        }

        if (firstSame == 4 || secondSame == 4) {
            return "Four of a kind!";
        }

        if (firstSame == 3 || secondSame == 3) {
            if (firstSame == 2 || secondSame == 2) {
                return "Full house!";
            } else {
                return "Three of a kind!";
            }
        }

        if (firstSame == 2 && secondSame == 2) {
            return "Two pairs";
        }

        if (firstSame == 2 || secondSame == 2) {
            return "Pair!";
        }
        if(total[0] == 1){
            return String.format("Hight card %1s", faces[0]);
        }
        
        for (int i = total.length - 1; i >= 0; i--) {
            if(total[i] == 1){
                return String.format("Hight card %1s", faces[i] );
            }
        }
        
        return "Nothing";
        
    }

    private boolean isFlush() {
        for (int i = 1; i < this.hand.length; i++) {
            if (!this.hand[i].getSuit().equals(this.hand[i - 1].getSuit())) {
                return false;
            }
        }
        return true;
    }

    private int consequitiveCount() {
        int[] total = this.totalHand();
        int count = 1;
        for (int i = 1; i < total.length; i++) {
            if (total[i] == 1 && total[i] == total[i - 1]) {
                count++;
            }else{
                if(count != 5){
                    count = 0;
                    break;
                }
            }
        }

        if (count == 4) {
            if (total[0] != 1 || total[0] == total[total.length - 1]) {
                count = 6;
            }
        }

        return count;
    }

    private int[] totalHand() {
        int[] array = new int[13];
        for (Card hand1 : this.hand) {
            array[Arrays.asList(faces).indexOf(hand1.getFace())]++;
        }
        return array;
    }
} // end class DeckOfCards

/**
 * ************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */

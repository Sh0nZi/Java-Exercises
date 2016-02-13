/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenization;

import java.util.Random;

/**
 *
 * @author sstoyanov
 */
public class Card {

    private String number;
    private String token = "";

    public Card(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("%-20s %s", this.number, this.token);
    }
}

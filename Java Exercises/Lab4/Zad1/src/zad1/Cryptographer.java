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
public class Cryptographer {

    private final int SHIFT_LENGTH = 3;

    public String encrypt(String text) {
        char[] textAsChars = text.toCharArray();
        String result = "";
        for (Character ch : textAsChars) {
            if ((int) ch < 88 || (ch > 91 && (int) ch < 120)) {
                result += (char) ((int) ch + SHIFT_LENGTH);
            } else {
                result += (char) ((int) ch - 26 + SHIFT_LENGTH);
            }
        }
        return result;
    }

    public String decrypt(String text) {
        char[] textAsChars = text.toCharArray();
        String result = "";
        for (Character ch : textAsChars) {
            if (((int) ch > 68 && ch < 91) || (int) ch > 100) {
                result += (char) ((int) ch - SHIFT_LENGTH);
            } else {
                result += (char) ((int) ch + 26 - SHIFT_LENGTH);
            }
        }
        return result;
    }

}

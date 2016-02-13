/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenization;

import java.util.Arrays;

/**
 *
 * @author sstoyanov
 */
public class User {

    private final String username;
    private final String password;
    private final UserRights[] rights;

    public User(String username, String password, UserRights[] rights) {
        this.username = username;
        this.password = password;
        this.rights = rights;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean hasRight(UserRights right) {
        return Arrays.asList(rights).contains(right);
    }
}

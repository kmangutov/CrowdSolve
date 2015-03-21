package com.kmangutov.crowdsolve.models;

/**
 * Created by kmangutov on 3/21/15.
 */
public class User {

    public String email;
    public String password;
    public String password_confirmation;

    public User(String name, String pass) {

        email = name;
        password = pass;
        password_confirmation = pass;
    }
}

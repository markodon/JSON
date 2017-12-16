package com.example.markodonovski.json.Models;

import java.io.Serializable;

/**
 * Created by markodonovski on 12/16/17.
 */

public class User implements Serializable {

    public String name;
    public String lastname;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

}

package com.example.markodonovski.json.Models;

import java.io.Serializable;

/**
 * Created by markodonovski on 12/16/17.
 */

public class User implements Serializable {

    public String name;
    public String lastname;
    public String username;
    public String password;
    public String slika;
    public String adress;
    int age;

    public User(String name, String lastname, String username, String password, String slika, String adress, int age) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.slika = slika;
        this.adress = adress;
        this.age = age;
    }


}

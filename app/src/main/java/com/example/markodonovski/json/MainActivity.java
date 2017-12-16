package com.example.markodonovski.json;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.markodonovski.json.Models.User;
import com.google.gson.Gson;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.lastname)
    EditText lastname;
    @BindView(R.id.adress)
    EditText adress;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.age)
    EditText age;
    @BindView(R.id.img)
    EditText slika;
    @BindView(R.id.btn1)
    Button vnesi;

    String defaultSlika = "http://simpleicon.com/wp-content/uploads/user1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        vnesi.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                name.setText("");
//                lastname.setText("");
//
//
//                return true;
//            }
//        });


    }


    @OnClick(R.id.btn1)
    public void Vnesi() {

        String imeRezultat = name.getText().toString();
        String prezimeRezultat = lastname.getText().toString();
        String adressRezultat = adress.getText().toString();
        String usernameRezultat = username.getText().toString();
        String passwordRezulat = password.getText().toString();
        age.setText("0");
        String godinaPromenliva = age.getText().toString();
        int god = Integer.parseInt(godinaPromenliva);

        defaultSlika = slika.getText().toString();

        if (!imeRezultat.isEmpty() && !prezimeRezultat.isEmpty() && !adressRezultat.isEmpty() && !usernameRezultat.isEmpty() && !passwordRezulat.isEmpty() && !godinaPromenliva.isEmpty()) {

            SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
//        preferences.edit().putString("Ime", imeRezultat).apply();
//        preferences.edit().putString("Prezime", prezimeRezultat).apply();
            User user = new User(imeRezultat, prezimeRezultat, usernameRezultat, passwordRezulat, defaultSlika, adressRezultat, god);
            Gson gson = new Gson();
            String mapString = gson.toJson(user);
            preferences.edit().putString("User", mapString).apply();

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        } else {
            vnesi.setError("Fields are Empty");
        }
    }

    @OnClick(R.id.btn2)
    public void Load() {
        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
//        String name = preferences.getString("Ime", "");
//        String lastname = preferences.getString("Prezime", "");
        User user1;
        Gson gson = new Gson();
        user1 = gson.fromJson(preferences.getString("User", ""), User.class);
        name.setText(user1.name);
        lastname.setText(user1.lastname);

    }

}

package com.example.markodonovski.json;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.markodonovski.json.Models.User;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etext1)
    EditText text1;
    @BindView(R.id.etext2)
    EditText text2;
    @BindView(R.id.btn1)
    Button vnesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        vnesi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                text1.setText("");
                text2.setText("");


                return true;
            }
        });


    }


    @OnClick(R.id.btn1)
    public void Vnesi() {
        String imeRezultat = text1.getText().toString();
        String prezimeRezultat = text2.getText().toString();

        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
//        preferences.edit().putString("Ime", imeRezultat).apply();
//        preferences.edit().putString("Prezime", prezimeRezultat).apply();
        User user = new User(imeRezultat, prezimeRezultat);
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        preferences.edit().putString("User", mapString).apply();
    }

    @OnClick(R.id.btn2)
    public void Load() {
        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
//        String name = preferences.getString("Ime", "");
//        String lastname = preferences.getString("Prezime", "");
        User user1;
        Gson gson = new Gson();
        user1 = gson.fromJson(preferences.getString("User", ""), User.class);
        text1.setText(user1.name);
        text2.setText(user1.lastname);

    }

}

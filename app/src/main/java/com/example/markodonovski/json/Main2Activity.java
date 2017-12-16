package com.example.markodonovski.json;

import android.content.SharedPreferences;

import com.example.markodonovski.json.Adapters.PagerAdapter;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.markodonovski.json.Fragmenti.Fragment1;
import com.example.markodonovski.json.Fragmenti.Fragment2;
import com.example.markodonovski.json.Models.User;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.myPager)
    public
    ViewPager pager;
    @BindView(R.id.tab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
        User user1;
        Gson gson = new Gson();
        user1 = gson.fromJson(preferences.getString("User", ""), User.class);

        setUpPager(pager);
    }


    private void setUpPager(ViewPager pager) {
        PagerAdapter adapter = new PagerAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "Sign in");
        adapter.addFragment(new Fragment2(), "Users");


        pager.setAdapter(adapter);
    }

    public User GetUser(User user) {


        SharedPreferences preferences = getSharedPreferences("MyFiles", MODE_PRIVATE);

        if (preferences.contains("User")) {

            Gson gson = new Gson();

            user = gson.fromJson(preferences.getString("User", ""), User.class);

        }


        return user;

    }


}

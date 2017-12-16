package com.example.markodonovski.json.Fragmenti;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.markodonovski.json.Main2Activity;
import com.example.markodonovski.json.Models.User;
import com.example.markodonovski.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by markodonovski on 12/16/17.
 */

public class Fragment1 extends Fragment {

    @BindView(R.id.username)
    EditText user;
    @BindView(R.id.password)
    EditText pass;
    User user1;



    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, null);
        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn)
    public void Klik(){
        String username = user.getText().toString();
        String password = pass.getText().toString();
        user1 = ((Main2Activity)getActivity()).GetUser(user1);
        if (username.equals(user1.username) && password.equals(user1.password)){
            ((Main2Activity) getActivity()).pager.setCurrentItem(1);
        }else {
            user.setError("Wrong username or password");
            pass.setError("Wrong username or password");
        }


    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mUnbinder.unbind();
    }
}

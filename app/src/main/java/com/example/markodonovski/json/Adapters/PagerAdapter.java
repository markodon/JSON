package com.example.markodonovski.json.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by markodonovski on 12/16/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmenti = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        fragmenti.add(fragment);
        titles.add(title);



    }

    public PagerAdapter (FragmentManager fm) {

        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public int getCount() {
        return fragmenti.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }

}

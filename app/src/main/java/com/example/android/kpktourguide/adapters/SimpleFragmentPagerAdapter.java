package com.example.android.kpktourguide.adapters;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.kpktourguide.fragments.InformationFragment;
import com.example.android.kpktourguide.fragments.MapFragment;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "INFORMATION", "MAP"};

    public SimpleFragmentPagerAdapter (FragmentManager fm){

        super(fm);
    }

    @Override

    public Fragment getItem(int position) {

        if (position == 0) {

            return new InformationFragment();

        } else {

            return new MapFragment();

        }

    }

    @Override

    public int getCount() {

        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}




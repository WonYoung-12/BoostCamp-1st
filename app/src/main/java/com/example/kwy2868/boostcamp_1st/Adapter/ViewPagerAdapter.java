package com.example.kwy2868.boostcamp_1st.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.kwy2868.boostcamp_1st.View.FirstFragment;
import com.example.kwy2868.boostcamp_1st.View.FourthFragment;
import com.example.kwy2868.boostcamp_1st.View.SecondFragment;
import com.example.kwy2868.boostcamp_1st.View.ThirdFragment;

/**
 * Created by kwy2868 on 2017-07-05.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            case 3:
                return new FourthFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

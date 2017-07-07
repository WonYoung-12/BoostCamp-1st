package com.example.kwy2868.boostcamp_1st.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kwy2868.boostcamp_1st.R;

/**
 * Created by kwy2868 on 2017-07-05.
 */

public class ThirdFragment extends android.support.v4.app.Fragment{
    public ThirdFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }
}

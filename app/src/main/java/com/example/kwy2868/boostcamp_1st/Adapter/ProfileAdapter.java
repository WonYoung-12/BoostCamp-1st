package com.example.kwy2868.boostcamp_1st.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kwy2868.boostcamp_1st.Model.ProfileList;
import com.example.kwy2868.boostcamp_1st.ViewHolder.ProfileViewHolder;
import com.example.kwy2868.boostcamp_1st.R;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder>{
    // 사람 명수.
    private int count;
    // 뷰홀더 객체.
    private ProfileViewHolder profileViewHolder;
    private ProfileList profileList;

    public ProfileAdapter(int count) {
        this.count = count;
    }

    public void setProfileList(ProfileList profileList) {
        this.profileList = profileList;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.column;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutForListItem, parent, shouldAttachToParentImmediately);
        profileViewHolder = new ProfileViewHolder(view);
        profileViewHolder.setProfileList(profileList);

        return profileViewHolder;
    }

    // 데이터들을 뷰에 묶어준다.
    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Log.d("Item Number", "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return count;
    }
}

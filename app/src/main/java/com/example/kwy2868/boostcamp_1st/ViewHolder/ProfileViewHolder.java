package com.example.kwy2868.boostcamp_1st.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwy2868.boostcamp_1st.Model.Profile;
import com.example.kwy2868.boostcamp_1st.Model.ProfileList;
import com.example.kwy2868.boostcamp_1st.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class ProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CircleImageView profileImage;
    private TextView textView;
    private ProfileList profileList;
    private View view;

    public void setProfileList(ProfileList profileList) {
        this.profileList = profileList;
    }

    public ProfileViewHolder(View itemView) {
        super(itemView);

        view = itemView;
        itemView.setOnClickListener(this);
        profileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
        textView = (TextView) itemView.findViewById(R.id.profile_name);

    }

    // 이미지랑 사람 이름 묶어주자.
    public void bind(int position) {
        Profile profile = (Profile) profileList.getArrayList().get(position);
//        int img = profile.getImage();

        profileImage.setImageResource(profile.getImage());

        // 나 아니면 이미지 흐리게 해주자.
        // 여기서 처리해줘야 할 듯..?
        if (position != 0) {
//            Log.d("position", "position : " + position);
//            Log.d("name", "name : " + profile.getName());
//            Drawable drawable = ((ImageView)view.findViewById(R.id.profile_image)).getDrawable();
//            //            drawable.setAlpha(20);
////            Drawable drawable = view.getContext().getDrawable(img);
//            Log.d("drawable", " " + drawable);
//            drawable.setAlpha(50);
//            profileImage.setImageDrawable(drawable);

        }
        // 내 프로필.
//        else {
//            profileImage.setImageResource(profile.getImage());
//        }
        textView.setText(profile.getName());
    }

    // 이러지 말고 interface 하나 만들어서 따로 처리를 해준다.
    @Override
    public void onClick(View v) {
        Log.d("position", "position : " + getAdapterPosition());
        Profile profile = (Profile) profileList.getArrayList().get(getAdapterPosition());
        Toast.makeText(v.getContext(), profile.getName() + "님에게 메시지를 보내시겠습니까?", Toast.LENGTH_SHORT).show();
    }
}

package com.example.kwy2868.boostcamp_1st.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwy2868.boostcamp_1st.Adapter.PostAdapter;
import com.example.kwy2868.boostcamp_1st.Adapter.ProfileAdapter;
import com.example.kwy2868.boostcamp_1st.Model.Post;
import com.example.kwy2868.boostcamp_1st.Model.PostList;
import com.example.kwy2868.boostcamp_1st.Model.Profile;
import com.example.kwy2868.boostcamp_1st.Model.ProfileList;
import com.example.kwy2868.boostcamp_1st.R;

import java.util.ArrayList;

/**
 * Created by kwy2868 on 2017-07-05.
 */

public class FirstFragment extends android.support.v4.app.Fragment {

    // 우선 사람은 10명만 해놓자.
    private static final int PROFILE_COUNT = 15;
    // 가로 리사이클러뷰 사용을 위한 변수.
    private static final int HORIZONTAL = 0;

    private static final String[] NAME_LIST = {"김원영", "박보미", "이승우", "장재광", "정다훈",
            "최동진", "홍길동", "다람쥐", "두루미", "고길동",
            "김길동", "강길동", "생각이", "안난다", "뭘하지"};

    private static final int[] USER_IMG_LIST = {R.drawable.profile, R.drawable.go, R.drawable.go2, R.drawable.hyuna, R.drawable.iu,
            R.drawable.hyuna2, R.drawable.iu2, R.drawable.suhyeon, R.drawable.suzy, R.drawable.suzy2,
            R.drawable.suzy3, R.drawable.suzy4, R.drawable.suzy5, R.drawable.taeyeon, R.drawable.top};

    // 포스트 개수는 3개만 테스트용.
    private static final int POST_COUNT = 3;

    private static final String[] POST_USER_NAME_LIST = {"김원영", "고준희", "현아"};
    private static final int[] POST_USER_IMG_LIST = {R.drawable.profile, R.drawable.go, R.drawable.hyuna};
    private static final String[] POST_LIST = {"스케줄입니다.", "조 구성입니다.", "참고 자료입니다."};
    private static final int[] POST_IMG_LIST = {R.drawable.schedule, R.drawable.group, R.drawable.reference};



    private ProfileAdapter profileAdapter;
    // private ProfileViewHolder viewHolder;
    private RecyclerView directRecyclerView;

    private PostAdapter postAdapter;
    private RecyclerView postRecyclerView;

    private TextView updateTextView;
    private Button liveButton;
    private Button pictureButton;
    private Button checkinButton;

    public FirstFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 초기화 작업.
        init();
        // 클릭 리스너.
        setClickListener();
        // 사람들 프로필 생성.
        createProfile();
        // 게시할 포스트 생성.
        createPost();
    }

    void init(){

        ///// 다이렉트 리사이클러뷰
        directRecyclerView = (RecyclerView)getView().findViewById(R.id.directRecyclerView);
        LinearLayoutManager directlayoutManager = new LinearLayoutManager(getActivity(), HORIZONTAL, false);
        directRecyclerView.setLayoutManager(directlayoutManager);
        directRecyclerView.setHasFixedSize(true);
        profileAdapter = new ProfileAdapter(PROFILE_COUNT);
        directRecyclerView.setAdapter(profileAdapter);

        updateTextView = (TextView)getView().findViewById(R.id.update);
        liveButton = (Button)getView().findViewById(R.id.live);
        pictureButton = (Button)getView().findViewById(R.id.picture);
        checkinButton = (Button)getView().findViewById(R.id.checkin);

        ///// 포스트 리사이클러뷰
        postRecyclerView = (RecyclerView)getView().findViewById(R.id.postRecyclerView);
        LinearLayoutManager postlayoutManager = new LinearLayoutManager(getActivity());
        postRecyclerView.setLayoutManager(postlayoutManager);
        postRecyclerView.setHasFixedSize(true);
        postAdapter = new PostAdapter(POST_COUNT);
        postRecyclerView.setAdapter(postAdapter);
    }

    void setClickListener(){
        updateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setIcon(R.drawable.ic_menu_black_24dp).setTitle("게시글 작성").setMessage("게시글을 작성하러 갑니다.").setNeutralButton("닫기", null).show();
                Toast.makeText(getActivity(), "게시글을 작성하러 갑니다.", Toast.LENGTH_SHORT).show();
            }
        });

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "라이브 방송을 수행합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "사진을 올립니다.", Toast.LENGTH_SHORT).show();
            }
        });

        checkinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "체크인을 합니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 유저들 생성.
    void createProfile(){
        ArrayList arrayList = new ArrayList();
        for(int i=0; i<15; i++) {
            Profile profile = new Profile(NAME_LIST[i], USER_IMG_LIST[i]);
            arrayList.add(profile);
        }
        ProfileList profileList = new ProfileList(arrayList);
        profileAdapter.setProfileList(profileList);
    }

    // 게시물들 생성.
    void createPost(){
        ArrayList arrayList = new ArrayList();
        for(int i=0; i<3; i++){
            Post post = new Post(POST_USER_NAME_LIST[i], POST_USER_IMG_LIST[i], POST_LIST[i], POST_IMG_LIST[i]);
            arrayList.add(post);
        }
        PostList postList = new PostList(arrayList);
        postAdapter.setPostList(postList);
    }
}

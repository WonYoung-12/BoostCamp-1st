package com.example.kwy2868.boostcamp_1st.View;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.kwy2868.boostcamp_1st.Adapter.ViewPagerAdapter;
import com.example.kwy2868.boostcamp_1st.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ImageButton camera_btn;
    private ImageButton message_btn;
    private EditText search;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    // 이동 전의 페이지.
    private MenuItem prevBottomNavigation;

    private Button newsButton;
    private Button friendButton;
    private Button notificationButton;
    private Button settingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 초기화 작업.
        init();
        // 리스너.
        setListener();
    }

    // 초기화 작업 다 여기서 해주자.
    void init(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 툴바 좌우 여백을 없앤다.
        toolbar.setContentInsetsAbsolute(0, 0);

        camera_btn = (ImageButton)findViewById(R.id.camera);
        search = (EditText)findViewById(R.id.search);
        message_btn = (ImageButton)findViewById(R.id.message);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.news));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.friend));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.notification));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.setting2));
//        얘는 xml 파일 gravity 속성으로도 지정 가능.
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);
//        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        // 아래 버튼 4개 연결.
//        newsButton = (Button)findViewById(R.id.news);
//        friendButton = (Button)findViewById(R.id.friend);
//        notificationButton = (Button)findViewById(R.id.notification);
//        settingButton = (Button)findViewById(R.id.setting);
    }

    // 리스너들 다 달아주자.
    void setListener(){

        // 카메라 버튼 온클릭 리스너 달아준다.
        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "카메라 버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // EditText에서 엔터키 눌렀을때.
                // 추가기능으로 실제 페이스북 페이지 띄워주거나 하면 좋을듯??
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    String text = search.getText().toString();
                    Toast.makeText(getApplicationContext(), text + "를 검색하셨습니다.", Toast.LENGTH_SHORT).show();

                    return true;
                }
                else
                    return false;
            }
        });

        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "메시지 버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.click);
//                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()){
                    case 0:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 1:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 2:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 3:
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.nonclick);
//                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.news:
//                        viewPager.setCurrentItem(0);
//                        return true;
//                    case R.id.friend:
//                        viewPager.setCurrentItem(1);
//                        return true;
//                    case R.id.notification:
//                        viewPager.setCurrentItem(2);
//                        return true;
//                    case R.id.setting:
//                        viewPager.setCurrentItem(3);
//                        return true;
//                }
//                return false;
//            }
//        });

//        newsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "뉴스피드를 확인합니다.", Toast.LENGTH_SHORT).show();
//                viewPager.setCurrentItem(0);
//            }
//        });
//
//        friendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "친구 탭을 확인합니다.", Toast.LENGTH_SHORT).show();
//                viewPager.setCurrentItem(1);
//            }
//        });
//
//        notificationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "알림을 확인합니다.", Toast.LENGTH_SHORT).show();
//                viewPager.setCurrentItem(2);
//            }
//        });
//
//        settingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "설정탭을 확인 합니다.", Toast.LENGTH_SHORT).show();
//                viewPager.setCurrentItem(3);
//            }
//        });
    }

    // xml 파일에 onclick 속성 이용하면 이렇게 하면 되는거 아닌가??
    // 근데 안됨. 메소드 위치가 메인액티비티가 아니고 다른곳인가?
    void like(){
        Toast.makeText(this, "좋아요 하셨습니다.", Toast.LENGTH_SHORT).show();
    }

    void comment(){
        Toast.makeText(this, "댓글을 작성합니다.", Toast.LENGTH_SHORT).show();
    }

    void share(){
        Toast.makeText(this, "이 게시물을 타 사용자와 공유합니다.", Toast.LENGTH_SHORT).show();
    }
}

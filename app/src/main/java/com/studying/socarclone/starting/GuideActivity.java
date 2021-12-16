package com.studying.socarclone.starting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.studying.socarclone.R;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity {
    TextView login, register;
    ViewPager viewPager;
    ImageViewPagerAdapter imageViewPagerAdapter;
    Timer timer;
    int itemCount = 5;
    final long DELAY_MS = 3000; // 자동으로 넘어가기 전에 딜레이
    final long PERIOD_MS = 3000; // 딜레이가 끝나고 몇초뒤에 자동으로 넘어갈건지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activity_guide);

        viewPager = findViewById(R.id.viewpager_image);
        imageViewPagerAdapter = new ImageViewPagerAdapter(this);
        viewPager.setAdapter(imageViewPagerAdapter);
        viewPager.setCurrentItem(itemCount);
        viewPager.setOffscreenPageLimit(3);

        // 여기 뷰페이저 자동으로 넘어가게 하는 부분 구현하기
//        final Handler handler = new Handler();
//
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//            }
//        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent_login = new Intent(GuideActivity.this, LoginFragment.class);
        Intent intent_register = new Intent(GuideActivity.this, RegisterFragment.class);

        login = findViewById(R.id.textview_login);
        register = findViewById(R.id.textview_register);

        login.setOnClickListener(v -> new Thread(new Runnable() {
            @Override
            public void run() {
                startActivity(intent_login);
            }
        }));

        register.setOnClickListener(v -> new Thread(new Runnable() {
            @Override
            public void run() {
                startActivity(intent_register);
            }
        }));
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
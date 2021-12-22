package com.studying.socarclone.starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.studying.socarclone.databinding.ActivityGuideBinding;
import com.studying.socarclone.sign.LoginActivity;
import com.studying.socarclone.sign.TermsActivity;
import com.studying.socarclone.sign.WarningActivity;

public class GuideActivity extends AppCompatActivity {
    ImageViewPagerAdapter imageViewPagerAdapter;
    ActivityGuideBinding guideBinding;
    int itemCount = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        guideBinding = ActivityGuideBinding.inflate(getLayoutInflater());
        setContentView(guideBinding.getRoot());

        imageViewPagerAdapter = new ImageViewPagerAdapter(this);
        guideBinding.viewpagerImage.setAdapter(imageViewPagerAdapter);
        guideBinding.viewpagerImage.setCurrentItem(itemCount);
        guideBinding.viewpagerImage.setOffscreenPageLimit(3);
        // 여기 뷰페이저 자동으로 넘어가게 하는 부분 구현하기

        guideBinding.textviewLogin.setOnClickListener(view -> {
            Intent intent_login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent_login);
        });

        guideBinding.textviewRegister.setOnClickListener(view -> {
            Intent intent_register = new Intent(getApplicationContext(), WarningActivity.class);
            startActivity(intent_register);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        guideBinding = null;
    }
}
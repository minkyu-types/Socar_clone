package com.studying.socarclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.studying.socarclone.databinding.ActivityGuideBinding;
import com.studying.socarclone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
    }
}
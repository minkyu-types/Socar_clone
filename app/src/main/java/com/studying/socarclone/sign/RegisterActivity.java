package com.studying.socarclone.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding registerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(registerBinding.getRoot());
    }
}
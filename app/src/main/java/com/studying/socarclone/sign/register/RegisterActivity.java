package com.studying.socarclone.sign.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityRegisterBinding;
import com.studying.socarclone.initiate.Authentication.AuthenticationActivity;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding registerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(registerBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();

//        registerBinding.buttonCompleteRegister.setClickable(false);
//        registerBinding.buttonCompleteRegister.setBackgroundResource(R.color.gray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerBinding = null;
    }
}
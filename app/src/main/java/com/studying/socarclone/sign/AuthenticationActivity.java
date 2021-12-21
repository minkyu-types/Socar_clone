package com.studying.socarclone.sign;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {
    ActivityAuthenticationBinding authenticationBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationBinding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(authenticationBinding.getRoot());

        authenticationBinding.buttonCompleteAuthentication.setEnabled(false);
        authenticationBinding.buttonCompleteAuthentication.setBackgroundResource(R.color.gray);
    }

    @Override
    protected void onResume() {
        super.onResume();

        authenticationBinding.linearlayoutAuth1.setOnClickListener(view -> {
            if(authenticationBinding.authCheckbox1.isChecked()){

            } else {

            }
        });
        authenticationBinding.relativelayoutAuthenticate1.setOnClickListener(view -> {

        });
        authenticationBinding.relativelayoutAuthenticate2.setOnClickListener(view -> {

        });
        authenticationBinding.relativelayoutAuthenticate3.setOnClickListener(view -> {

        });
        authenticationBinding.relativelayoutAuthenticate4.setOnClickListener(view -> {

        });
        authenticationBinding.relativelayoutAuthenticate5.setOnClickListener(view -> {

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;
    }
}
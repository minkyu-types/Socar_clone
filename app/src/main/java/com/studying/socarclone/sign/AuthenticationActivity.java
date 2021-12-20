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

import com.studying.socarclone.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {
    ActivityAuthenticationBinding authenticationBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationBinding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        View view = authenticationBinding.getRoot();

        setContentView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;
    }
}
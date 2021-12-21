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
import android.widget.CompoundButton;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {
    ActivityAuthenticationBinding authenticationBinding;
    int terms_authenticate_1;
    int terms_authenticate_1_1, terms_authenticate_1_2, terms_authenticate_1_3, terms_authenticate_1_4, terms_authenticate_1_5;
    int name_check, jumin_check, phonenum_check;
    int phone_authenticate;

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

        authenticationBinding.imageviewAuthGo.setOnClickListener(view -> {
            if(authenticationBinding.constraintlayoutAuth1.getVisibility() == View.GONE){
                authenticationBinding.constraintlayoutAuth1.setVisibility(View.VISIBLE);
            } else {
                authenticationBinding.constraintlayoutAuth1.setVisibility(View.GONE);
            }
        });

        authenticationBinding.authenticationCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(authenticationBinding.authCheckbox1.isChecked()){
                    terms_authenticate_1 = 1;
                } else {
                    terms_authenticate_1 = 0;
                }
            }
        });

        authenticationBinding.linearlayoutAuth1.setOnClickListener(view -> {
            if(authenticationBinding.authCheckbox1.isChecked()){
                authenticationBinding.authenticationCheckbox1.setEnabled(true);
                authenticationBinding.authenticationCheckbox2.setEnabled(true);
                authenticationBinding.authenticationCheckbox3.setEnabled(true);
                authenticationBinding.authenticationCheckbox4.setEnabled(true);
                authenticationBinding.authenticationCheckbox5.setEnabled(true);
            } else {
                authenticationBinding.authenticationCheckbox1.setEnabled(false);
                authenticationBinding.authenticationCheckbox2.setEnabled(false);
                authenticationBinding.authenticationCheckbox3.setEnabled(false);
                authenticationBinding.authenticationCheckbox4.setEnabled(false);
                authenticationBinding.authenticationCheckbox5.setEnabled(false);
            }
        });
        authenticationBinding.relativelayoutAuthenticate1.setOnClickListener(view -> {
            if(authenticationBinding.authenticationCheckbox1.isChecked()){
                terms_authenticate_1_1 = 1;
            } else {
                terms_authenticate_1_1 = 0;
            }
        });
        authenticationBinding.relativelayoutAuthenticate2.setOnClickListener(view -> {
            if(authenticationBinding.authenticationCheckbox1.isChecked()){
                terms_authenticate_1_2 = 1;
            } else {
                terms_authenticate_1_2 = 0;
            }
        });
        authenticationBinding.relativelayoutAuthenticate3.setOnClickListener(view -> {
            if(authenticationBinding.authenticationCheckbox1.isChecked()){
                terms_authenticate_1_3 = 1;
            } else {
                terms_authenticate_1_3 = 0;
            }
        });
        authenticationBinding.relativelayoutAuthenticate4.setOnClickListener(view -> {
            if(authenticationBinding.authenticationCheckbox1.isChecked()){
                terms_authenticate_1_4 = 1;
            } else {
                terms_authenticate_1_4 = 0;
            }
        });
        authenticationBinding.relativelayoutAuthenticate5.setOnClickListener(view -> {
            if(authenticationBinding.authenticationCheckbox1.isChecked()){
                terms_authenticate_1_5 = 1;
            } else {
                terms_authenticate_1_5 = 0;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;
    }
}
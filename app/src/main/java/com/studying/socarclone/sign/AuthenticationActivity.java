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

        setAllLayoutClickListener();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;
    }

    public void setAllLayoutClickListener() {

        authenticationBinding.authenticationCheckbox1.setClickable(false);
        authenticationBinding.authenticationCheckbox2.setClickable(false);
        authenticationBinding.authenticationCheckbox3.setClickable(false);
        authenticationBinding.authenticationCheckbox4.setClickable(false);
        authenticationBinding.authenticationCheckbox5.setClickable(false);

        authenticationBinding.linearlayoutAuth1.setOnClickListener(view -> {
            if(!authenticationBinding.authCheckbox1.isChecked()){
                authenticationBinding.authCheckbox1.setChecked(true); // 얘 안넣으면 하위 컴포넌트에 종속됩니다 ^^ 부하들이 안놔줌
                authenticationBinding.authenticationCheckbox1.setChecked(true);
                authenticationBinding.authenticationCheckbox2.setChecked(true);
                authenticationBinding.authenticationCheckbox3.setChecked(true);
                authenticationBinding.authenticationCheckbox4.setChecked(true);
                authenticationBinding.authenticationCheckbox5.setChecked(true);
            } else {
                authenticationBinding.authCheckbox1.setChecked(false);
                authenticationBinding.authenticationCheckbox1.setChecked(false);
                authenticationBinding.authenticationCheckbox2.setChecked(false);
                authenticationBinding.authenticationCheckbox3.setChecked(false);
                authenticationBinding.authenticationCheckbox4.setChecked(false);
                authenticationBinding.authenticationCheckbox5.setChecked(false);
            }
        });

        authenticationBinding.relativelayoutAuthenticate1.setOnClickListener(view -> {
            if(!authenticationBinding.authenticationCheckbox1.isChecked()){
                authenticationBinding.authenticationCheckbox1.setChecked(true);

                if(authenticationBinding.authenticationCheckbox2.isChecked() && authenticationBinding.authenticationCheckbox3.isChecked() && authenticationBinding.authenticationCheckbox4.isChecked() && authenticationBinding.authenticationCheckbox5.isChecked()){
                    authenticationBinding.authCheckbox1.setChecked(true);
                    authenticationBinding.authenticationCheckbox1.setChecked(true);
                }
            } else {
                authenticationBinding.authenticationCheckbox1.setChecked(false);
                authenticationBinding.authCheckbox1.setChecked(false);
            }
        });
        authenticationBinding.relativelayoutAuthenticate2.setOnClickListener(view -> {
            if(!authenticationBinding.authenticationCheckbox2.isChecked()){
                authenticationBinding.authenticationCheckbox2.setChecked(true);

                if(authenticationBinding.authenticationCheckbox1.isChecked() && authenticationBinding.authenticationCheckbox3.isChecked() && authenticationBinding.authenticationCheckbox4.isChecked() && authenticationBinding.authenticationCheckbox5.isChecked()){
                    authenticationBinding.authCheckbox1.setChecked(true);
                    authenticationBinding.authenticationCheckbox2.setChecked(true);
                }
            } else {
                authenticationBinding.authenticationCheckbox2.setChecked(false);
                authenticationBinding.authCheckbox1.setChecked(false);
            }
        });
        authenticationBinding.relativelayoutAuthenticate3.setOnClickListener(view -> {
            if(!authenticationBinding.authenticationCheckbox3.isChecked()){
                authenticationBinding.authenticationCheckbox3.setChecked(true);

                if(authenticationBinding.authenticationCheckbox1.isChecked() && authenticationBinding.authenticationCheckbox2.isChecked() && authenticationBinding.authenticationCheckbox4.isChecked() && authenticationBinding.authenticationCheckbox5.isChecked()){
                    authenticationBinding.authCheckbox1.setChecked(true);
                    authenticationBinding.authenticationCheckbox3.setChecked(true);
                }
            } else {
                authenticationBinding.authenticationCheckbox3.setChecked(false);
                authenticationBinding.authCheckbox1.setChecked(false);
            }
        });
        authenticationBinding.relativelayoutAuthenticate4.setOnClickListener(view -> {
            if(!authenticationBinding.authenticationCheckbox4.isChecked()){
                authenticationBinding.authenticationCheckbox4.setChecked(true);

                if(authenticationBinding.authenticationCheckbox1.isChecked() && authenticationBinding.authenticationCheckbox2.isChecked() && authenticationBinding.authenticationCheckbox3.isChecked() && authenticationBinding.authenticationCheckbox5.isChecked()){
                    authenticationBinding.authCheckbox1.setChecked(true);
                    authenticationBinding.authenticationCheckbox4.setChecked(true);
                }
            } else {
                authenticationBinding.authenticationCheckbox4.setChecked(false);
                authenticationBinding.authCheckbox1.setChecked(false);
            }
        });
        authenticationBinding.relativelayoutAuthenticate5.setOnClickListener(view -> {
            if(!authenticationBinding.authenticationCheckbox5.isChecked()){
                authenticationBinding.authenticationCheckbox5.setChecked(true);

                if(authenticationBinding.authenticationCheckbox1.isChecked() && authenticationBinding.authenticationCheckbox2.isChecked() && authenticationBinding.authenticationCheckbox3.isChecked() && authenticationBinding.authenticationCheckbox4.isChecked()){
                    authenticationBinding.authCheckbox1.setChecked(true);
                    authenticationBinding.authenticationCheckbox5.setChecked(true);
                }
            } else {
                authenticationBinding.authenticationCheckbox5.setChecked(false);
                authenticationBinding.authCheckbox1.setChecked(false);
            }
        });
    }
}
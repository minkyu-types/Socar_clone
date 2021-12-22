package com.studying.socarclone.sign;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityAuthenticationBinding;

public class AuthenticationActivity extends AppCompatActivity {
    ActivityAuthenticationBinding authenticationBinding;
    final CharSequence[] company = {"SKT", "KT", "LGU+", "SKT 알뜰폰", "KT 알뜰폰", "LGU+ 알뜰폰"};
    String name;
    String jumin_front, jumin_back;
    String phone_company, phone_num;
    String authentication_num;
    boolean authentication_check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationBinding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(authenticationBinding.getRoot());

        authenticationBinding.buttonCompleteAuthentication.setEnabled(false);
        authenticationBinding.buttonCompleteAuthentication.setBackgroundResource(R.color.gray);

        authenticationBinding.linearlayoutAuthPhone.setOnClickListener(view -> {
            alertDialogSelectPopup();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        setAllLayoutClickListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;
    }

    public void alertDialogSelectPopup(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //제목
        alertDialogBuilder.setTitle("통신사");
        alertDialogBuilder.setItems(company, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setGravity(Gravity.BOTTOM);
        alertDialog.show();

    }

    public void setAllLayoutClickListener() {

        authenticationBinding.authenticationCheckbox1.setClickable(false);
        authenticationBinding.authenticationCheckbox2.setClickable(false);
        authenticationBinding.authenticationCheckbox3.setClickable(false);
        authenticationBinding.authenticationCheckbox4.setClickable(false);
        authenticationBinding.authenticationCheckbox5.setClickable(false);

        authenticationBinding.imageviewAuthGo.setOnClickListener(view -> {
            if(authenticationBinding.constraintlayoutAuth1.getVisibility() == View.GONE){
                authenticationBinding.constraintlayoutAuth1.setVisibility(View.VISIBLE);
            } else {
                authenticationBinding.constraintlayoutAuth1.setVisibility(View.GONE);
            }
        });

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
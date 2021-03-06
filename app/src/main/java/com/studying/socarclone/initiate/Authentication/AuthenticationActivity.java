package com.studying.socarclone.initiate.Authentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityAuthenticationBinding;
import com.studying.socarclone.initiate.TermsActivity;
import com.studying.socarclone.sign.register.RegisterActivity;

public class AuthenticationActivity extends AppCompatActivity {
    ActivityAuthenticationBinding authenticationBinding;
    final CharSequence[] company = {"SKT", "KT", "LGU+", "SKT 알뜰폰", "KT 알뜰폰", "LGU+ 알뜰폰"};
    final CharSequence[] foreign = {"내국인", "외국인"};
    String name;
    String jumin_front, jumin_back;
    String phone_company, phone_num;
    String authentication_num;
    boolean authentication_check;
    CountDownTimer timer;
    int time = 180000, count = 1;
    int second = 59;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationBinding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(authenticationBinding.getRoot());

        authenticationBinding.buttonCompleteAuthentication.setEnabled(true);
        authenticationBinding.buttonCompleteAuthentication.setBackgroundResource(R.color.socar_color);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAuthenticationLayoutClickListener();

        authenticationBinding.linearlayoutAuthForeign.setOnClickListener(view -> {
            alertDialogForeignSelectPopup();
        });

        authenticationBinding.linearlayoutAuthPhone.setOnClickListener(view -> {
            alertDialogPhoneSelectPopup();
        });

        authenticationBinding.buttonCompleteAuthentication.setOnClickListener(view -> {
            Intent intent_complete = new Intent(this, RegisterActivity.class);
            startActivity(intent_complete);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authenticationBinding = null;

        timer.cancel();
        try{
            timer.cancel();
        } catch (Exception e){}
        timer = null;
        finish();
    }

    // 타이머
    private void authenticationTimer(){

        timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                if(time <= 179000){ // 2분 59초 남으면 분을 2로 설정
                    authenticationBinding.textviewAuthenticationTimerMinute.setText("02:");
                    authenticationBinding.textviewAuthenticationTimerSecond.setText(""+second);

                    if(time == 120000){
                        second = 0;
                    }
                } else if(time <= 119000){ // 1분 59초 남으면 분을 1로 설정
                    authenticationBinding.textviewAuthenticationTimerMinute.setText("01:");
                    authenticationBinding.textviewAuthenticationTimerSecond.setText(""+second);

                    if(time == 60000){
                        second = 0;
                    }
                } else if(time <= 59000){ // 59초 남으면 분을 0로 설정
                    authenticationBinding.textviewAuthenticationTimerMinute.setText("00:");
                    authenticationBinding.textviewAuthenticationTimerSecond.setText(""+second);

                    if(time == 0){
                        second = 0;
                    }
                }
            }

            @Override
            public void onFinish() {
                authenticationBinding.textviewAuthenticationTimerMinute.setText("시간");
                authenticationBinding.textviewAuthenticationTimerSecond.setText("만료");
            }
        }.start();
    }

    // 커스텀 국적 콤보박스 팝업
    private void alertDialogForeignSelectPopup(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //제목
        alertDialogBuilder.setTitle("국적 선택");
        alertDialogBuilder.setItems(foreign, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                authenticationBinding.textviewAuthenticationForeign.setText(foreign[i]);

                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setGravity(Gravity.BOTTOM);
        alertDialog.show();
    }

    // 커스텀 통신사 콤보박스 팝업
    private void alertDialogPhoneSelectPopup(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //제목
        alertDialogBuilder.setTitle("통신사");
        alertDialogBuilder.setItems(company, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                authenticationBinding.textviewPhoneCompany.setText(company[i]);

                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setGravity(Gravity.BOTTOM);
        alertDialog.show();
    }

    // 클릭 리스너
    private void setAuthenticationLayoutClickListener() {
        authenticationBinding.authCheckbox1.setClickable(false);
        authenticationBinding.authenticationCheckbox1.setClickable(false);
        authenticationBinding.authenticationCheckbox2.setClickable(false);
        authenticationBinding.authenticationCheckbox3.setClickable(false);
        authenticationBinding.authenticationCheckbox4.setClickable(false);
        authenticationBinding.authenticationCheckbox5.setClickable(false);

        authenticationBinding.buttonAuthBack.setOnClickListener(view -> {
            Intent intent_back = new Intent(getApplicationContext(), TermsActivity.class);
            startActivity(intent_back);
        });

        authenticationBinding.buttonAuthentication.setOnClickListener(view -> {

            authenticationBinding.buttonCompleteAuthentication.setClickable(true);
            authenticationBinding.buttonCompleteAuthentication.setBackgroundResource(R.color.socar_color);
            authenticationBinding.buttonAuthentication.setText("재발송");

            authenticationTimer();
            timer.start();

            if(!authenticationBinding.authCheckbox1.isChecked()){
                authenticationBinding.linearlayoutAuth1.setBackgroundResource(R.drawable.shape_red_edge_error);
            }

            if(!authenticationBinding.edittextAuthenticationName.getText().equals("")){
                authenticationBinding.edittextAuthenticationName.setBackgroundResource(R.drawable.shape_red_edge_error);
            }

            if(authenticationBinding.edittextAuthenticationJuminFirst.getText().toString().length() < 6){
                authenticationBinding.linearlayoutAuthJumin.setBackgroundResource(R.drawable.shape_red_edge_error);
            }

            if(authenticationBinding.edittextAuthenticationJuminLast.getText().toString().length() < 1){
                authenticationBinding.linearlayoutAuthJumin.setBackgroundResource(R.drawable.shape_red_edge_error);
            }

            if(authenticationBinding.textviewPhoneCompany.getText().toString().equals("선택")){
                authenticationBinding.linearlayoutAuth4.setBackgroundResource(R.drawable.shape_red_edge_error);
            }

            if(authenticationBinding.edittextAuthenticationPhoneNumber.getText().toString().length() < 11){
                authenticationBinding.linearlayoutAuth4.setBackgroundResource(R.drawable.shape_red_edge_error);
            }
        });

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

                authenticationBinding.constraintlayoutAuth1.setVisibility(View.GONE);
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
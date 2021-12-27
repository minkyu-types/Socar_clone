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
        edittextChangeListener();

        registerBinding.buttonCompleteRegister.setClickable(false);
        registerBinding.buttonCompleteRegister.setBackgroundResource(R.color.gray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerBinding = null;
    }

    private void edittextChangeListener(){
        if(!registerBinding.edittextRegisterId.getText().equals("")
                && !registerBinding.edittextRegisterPassword.getText().equals("")){

            if(registerBinding.edittextRegisterPassword.getText().equals(registerBinding.edittextRegisterPasswordCheck.getText())){
                registerBinding.buttonCompleteRegister.setClickable(true);
                registerBinding.buttonCompleteRegister.setBackgroundResource(R.color.socar_color);
            }
        }

        registerBinding.buttonRegisterBack.setOnClickListener(view -> {
            Intent intent_back = new Intent(this, AuthenticationActivity.class);
            startActivity(intent_back);
        });
    }
}
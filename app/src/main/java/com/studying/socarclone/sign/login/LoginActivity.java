package com.studying.socarclone.sign.login;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());

        SpannableString content = new SpannableString("가입정보 찾기");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        loginBinding.textviewFindInfo.setText(content);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loginBinding.buttonBack.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginBinding = null;
    }
}
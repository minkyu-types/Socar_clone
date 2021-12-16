package com.studying.socarclone.sign;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    TextView text_find_info;
    ActivityLoginBinding loginBinding;
    private LoginViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();

        SpannableString content = new SpannableString("가입정보 찾기");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        loginBinding.textviewFindInfo.setText(content);

        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginBinding = null;
    }
}
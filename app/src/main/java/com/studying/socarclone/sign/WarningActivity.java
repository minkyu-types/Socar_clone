package com.studying.socarclone.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityWarningBinding;

public class WarningActivity extends AppCompatActivity {
    ActivityWarningBinding warningBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        warningBinding = ActivityWarningBinding.inflate(getLayoutInflater());
        View view= warningBinding.getRoot();
        setContentView(view);

        warningBinding.buttonRegisterGo.setOnClickListener(view1 -> {
            Intent intent_register_go = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent_register_go);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        warningBinding = null;
    }
}
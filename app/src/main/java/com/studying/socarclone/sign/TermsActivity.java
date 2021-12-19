package com.studying.socarclone.sign;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityTermsBinding;

public class TermsActivity extends AppCompatActivity {
    ActivityTermsBinding termsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        termsBinding = ActivityTermsBinding.inflate(getLayoutInflater());
        setContentView(termsBinding.getRoot());

        termsBinding.buttonContinueRegister.setEnabled(false);
        termsBinding.buttonContinueRegister.setBackgroundResource(R.color.gray);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(termsBinding.checkbox1.isChecked()){
            checkbox1Checked();
            termsBinding.buttonContinueRegister.setBackgroundResource(R.color.socar_color);
            termsBinding.buttonContinueRegister.setEnabled(true);
        } else if(!termsBinding.checkbox1.isChecked()){
            checkbox1NotChecked();
            termsBinding.buttonContinueRegister.setBackgroundResource(R.color.gray);
            termsBinding.buttonContinueRegister.setEnabled(false);
        }

        termsBinding.buttonContinueRegister.setOnClickListener(view -> {
            Intent intent_continue_register = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent_continue_register);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        termsBinding = null;
    }

    public void checkbox1Checked(){
        checkbox2Checked();
        checkbox3Checked();
        termsBinding.checkbox1.setChecked(true);
    }

    public void checkbox2Checked(){
        termsBinding.checkbox21.setChecked(true);
        termsBinding.checkbox22.setChecked(true);
        termsBinding.checkbox23.setChecked(true);
        termsBinding.checkbox2.setChecked(true);
    }

    public void checkbox3Checked(){
        termsBinding.checkbox31.setChecked(true);
        termsBinding.checkbox32.setChecked(true);
        termsBinding.checkbox33.setChecked(true);
        termsBinding.checkbox3.setChecked(true);
    }

    public void checkbox1NotChecked(){
        checkbox2NotChecked();
        checkbox3NotChecked();
        termsBinding.checkbox1.setChecked(false);
    }

    public void checkbox2NotChecked(){
        termsBinding.checkbox21.setChecked(false);
        termsBinding.checkbox22.setChecked(false);
        termsBinding.checkbox23.setChecked(false);
        termsBinding.checkbox2.setChecked(false);
    }

    public void checkbox3NotChecked(){
        termsBinding.checkbox31.setChecked(false);
        termsBinding.checkbox32.setChecked(false);
        termsBinding.checkbox33.setChecked(false);
        termsBinding.checkbox3.setChecked(false);
    }
}
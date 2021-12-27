package com.studying.socarclone.initiate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityTermsBinding;
import com.studying.socarclone.initiate.Authentication.AuthenticationActivity;

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

        setTermsLayoutClickListener();

        termsBinding.checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(termsBinding.checkbox1.isChecked()){
                    termsBinding.buttonContinueRegister.setEnabled(true);
                    termsBinding.buttonContinueRegister.setBackgroundResource(R.color.socar_color);
                } else {
                    termsBinding.buttonContinueRegister.setEnabled(false);
                    termsBinding.buttonContinueRegister.setBackgroundResource(R.color.gray);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        termsBinding = null;
    }

    public void setTermsLayoutClickListener(){
        termsBinding.checkbox1.setClickable(false);
        termsBinding.checkbox2.setClickable(false);
        termsBinding.checkbox3.setClickable(false);
        termsBinding.checkbox21.setClickable(false);
        termsBinding.checkbox22.setClickable(false);
        termsBinding.checkbox23.setClickable(false);
        termsBinding.checkbox41.setClickable(false);
        termsBinding.checkbox42.setClickable(false);
        termsBinding.checkbox43.setClickable(false);

        termsBinding.linearlayout1.setOnClickListener(view -> {
            if(!termsBinding.checkbox1.isChecked()){
                termsBinding.checkbox1.setChecked(true);
                termsBinding.checkbox2.setChecked(true);
                termsBinding.checkbox21.setChecked(true);
                termsBinding.checkbox22.setChecked(true);
                termsBinding.checkbox23.setChecked(true);
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox41.setChecked(true);
                termsBinding.checkbox42.setChecked(true);
                termsBinding.checkbox43.setChecked(true);
            } else {
                termsBinding.checkbox1.setChecked(false);
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox21.setChecked(false);
                termsBinding.checkbox22.setChecked(false);
                termsBinding.checkbox23.setChecked(false);
                termsBinding.checkbox3.setChecked(false);
                termsBinding.checkbox41.setChecked(false);
                termsBinding.checkbox42.setChecked(false);
                termsBinding.checkbox43.setChecked(false);
            }
        });

        termsBinding.linearlayout2.setOnClickListener(view -> {
            if(!termsBinding.checkbox2.isChecked()){
                termsBinding.checkbox2.setChecked(true);
                termsBinding.checkbox21.setChecked(true);
                termsBinding.checkbox22.setChecked(true);
                termsBinding.checkbox23.setChecked(true);

                if(termsBinding.checkbox3.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                }
            } else {
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox21.setChecked(false);
                termsBinding.checkbox22.setChecked(false);
                termsBinding.checkbox23.setChecked(false);

                termsBinding.checkbox1.setChecked(false);
            }
        });

        termsBinding.linearlayout21.setOnClickListener(view -> {
            if(!termsBinding.checkbox21.isChecked()) {
                termsBinding.checkbox21.setChecked(true);

                if(termsBinding.checkbox22.isChecked() && termsBinding.checkbox23.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                    termsBinding.checkbox2.setChecked(true);
                }
            } else {
                termsBinding.checkbox1.setChecked(false);
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox21.setChecked(false);
            }
        });

        termsBinding.linearlayout22.setOnClickListener(view -> {
            if(!termsBinding.checkbox22.isChecked()) {
                termsBinding.checkbox22.setChecked(true);

                if(termsBinding.checkbox21.isChecked() && termsBinding.checkbox23.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                    termsBinding.checkbox2.setChecked(true);
                }
            } else {
                termsBinding.checkbox1.setChecked(false);
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox22.setChecked(false);
            }
        });

        termsBinding.linearlayout23.setOnClickListener(view -> {
            if(!termsBinding.checkbox23.isChecked()) {
                termsBinding.checkbox23.setChecked(true);

                if(termsBinding.checkbox21.isChecked() && termsBinding.checkbox22.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                    termsBinding.checkbox2.setChecked(true);
                }
            } else {
                termsBinding.checkbox1.setChecked(false);
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox23.setChecked(false);
            }
        });

        termsBinding.linearlayout3.setOnClickListener(view -> {
            if(!termsBinding.checkbox3.isChecked()){
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox41.setChecked(true);
                termsBinding.checkbox42.setChecked(true);
                termsBinding.checkbox43.setChecked(true);

                if(termsBinding.checkbox2.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                }
            } else {
                termsBinding.checkbox3.setChecked(false);
                termsBinding.checkbox41.setChecked(false);
                termsBinding.checkbox42.setChecked(false);
                termsBinding.checkbox43.setChecked(false);

                termsBinding.checkbox1.setChecked(false);
            }
        });

        termsBinding.linearlayout41.setOnClickListener(view -> {
            if(!termsBinding.checkbox41.isChecked()){
                termsBinding.checkbox1.setChecked(true);
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox41.setChecked(true);
            } else {
                termsBinding.checkbox41.setChecked(false);

                if(!termsBinding.checkbox42.isChecked() && !termsBinding.checkbox43.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
            }
        });

        termsBinding.linearlayout42.setOnClickListener(view -> {
            if(!termsBinding.checkbox42.isChecked()){
                termsBinding.checkbox1.setChecked(true);
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox42.setChecked(true);
            } else {
                termsBinding.checkbox42.setChecked(false);

                if(!termsBinding.checkbox41.isChecked() && !termsBinding.checkbox43.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
            }
        });

        termsBinding.linearlayout43.setOnClickListener(view -> {
            if(!termsBinding.checkbox43.isChecked()){
                termsBinding.checkbox1.setChecked(true);
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox43.setChecked(true);
            } else {
                termsBinding.checkbox43.setChecked(false);

                if(!termsBinding.checkbox41.isChecked() && !termsBinding.checkbox42.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
            }
        });

        termsBinding.buttonContinueRegister.setOnClickListener(view -> {
            Intent intent_continue_register = new Intent(getApplicationContext(), AuthenticationActivity.class);
            startActivity(intent_continue_register);
        });

        termsBinding.buttonTermsBack.setOnClickListener(view -> {
            Intent intent_terms_back = new Intent(getApplicationContext(), WarningActivity.class);
            startActivity(intent_terms_back);
        });
    }
}
package com.studying.socarclone.sign;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.studying.socarclone.R;
import com.studying.socarclone.databinding.ActivityTermsBinding;

public class TermsActivity extends AppCompatActivity {
    ActivityTermsBinding termsBinding;
    int terms_agree_1, terms_agree_2, terms_agree_3;
    int terms_agree_2_1, terms_agree_2_2, terms_agree_2_3;
    int terms_agree_3_1, terms_agree_3_2, terms_agree_3_3;

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

        termsBinding.checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(termsBinding.checkbox1.isChecked()){
                    terms_agree_1 = 1;

                    termsBinding.buttonContinueRegister.setEnabled(true);
                    termsBinding.buttonContinueRegister.setBackgroundResource(R.color.socar_color);
                } else {
                    terms_agree_1 = 0;

                    termsBinding.buttonContinueRegister.setEnabled(false);
                    termsBinding.buttonContinueRegister.setBackgroundResource(R.color.gray);
                }
            }
        });

        termsBinding.checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(termsBinding.checkbox2.isChecked()){
                    terms_agree_2 = 1;
                } else {
                    terms_agree_2 = 0;
                }
            }
        });

        termsBinding.checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(termsBinding.checkbox3.isChecked()){
                    terms_agree_3 = 1;

                } else {
                    terms_agree_3 = 0;
                }
            }
        });

        termsBinding.checkbox1.setOnClickListener(view -> {
            if(termsBinding.checkbox1.isChecked()){
                termsBinding.checkbox1.setChecked(true);
                termsBinding.checkbox2.setChecked(true);
                termsBinding.checkbox21.setChecked(true);
                termsBinding.checkbox22.setChecked(true);
                termsBinding.checkbox23.setChecked(true);
                termsBinding.checkbox3.setChecked(true);
                termsBinding.checkbox31.setChecked(true);
                termsBinding.checkbox32.setChecked(true);
                termsBinding.checkbox33.setChecked(true);
            } else {
                termsBinding.checkbox1.setChecked(false);
                termsBinding.checkbox2.setChecked(false);
                termsBinding.checkbox21.setChecked(false);
                termsBinding.checkbox22.setChecked(false);
                termsBinding.checkbox23.setChecked(false);
                termsBinding.checkbox3.setChecked(false);
                termsBinding.checkbox31.setChecked(false);
                termsBinding.checkbox32.setChecked(false);
                termsBinding.checkbox33.setChecked(false);
            }
        });

        termsBinding.checkbox2.setOnClickListener(view -> {
            if(termsBinding.checkbox2.isChecked()){
                termsBinding.checkbox21.setChecked(true);
                termsBinding.checkbox22.setChecked(true);
                termsBinding.checkbox23.setChecked(true);

                if(termsBinding.checkbox3.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                }
            } else {
                termsBinding.checkbox21.setChecked(false);
                termsBinding.checkbox22.setChecked(false);
                termsBinding.checkbox23.setChecked(false);

                termsBinding.checkbox1.setChecked(false);
            }
        });

        termsBinding.checkbox21.setOnClickListener(view -> {
            if(termsBinding.checkbox21.isChecked() && termsBinding.checkbox22.isChecked() && termsBinding.checkbox23.isChecked()){
                termsBinding.checkbox2.setChecked(true);
            } else {
                if(!termsBinding.checkbox22.isChecked() || !termsBinding.checkbox23.isChecked()){
                    termsBinding.checkbox2.setChecked(false);
                }
            }
        });

        termsBinding.checkbox22.setOnClickListener(view -> {
            if(termsBinding.checkbox21.isChecked() && termsBinding.checkbox22.isChecked() && termsBinding.checkbox23.isChecked()){
                termsBinding.checkbox2.setChecked(true);
            } else {
                if(!termsBinding.checkbox22.isChecked() || !termsBinding.checkbox23.isChecked()){
                    termsBinding.checkbox2.setChecked(false);
                }
            }
        });

        termsBinding.checkbox23.setOnClickListener(view -> {
            if(termsBinding.checkbox21.isChecked() && termsBinding.checkbox22.isChecked() && termsBinding.checkbox23.isChecked()){
                termsBinding.checkbox2.setChecked(true);
            } else {
                if(!termsBinding.checkbox22.isChecked() || !termsBinding.checkbox23.isChecked()){
                    termsBinding.checkbox2.setChecked(false);
                }
            }
        });

        termsBinding.checkbox3.setOnClickListener(view -> {
            if(termsBinding.checkbox3.isChecked()){
                termsBinding.checkbox31.setChecked(true);
                termsBinding.checkbox32.setChecked(true);
                termsBinding.checkbox33.setChecked(true);

                if(termsBinding.checkbox2.isChecked()){
                    termsBinding.checkbox1.setChecked(true);
                }
            } else {
                termsBinding.checkbox31.setChecked(false);
                termsBinding.checkbox32.setChecked(false);
                termsBinding.checkbox33.setChecked(false);

                termsBinding.checkbox1.setChecked(false);
            }
        });

        termsBinding.checkbox31.setOnClickListener(view -> {
            if(termsBinding.checkbox31.isChecked()){
                termsBinding.checkbox3.setChecked(true);
                terms_agree_3_1 = 1;
            } else {
                if(!termsBinding.checkbox32.isChecked() && !termsBinding.checkbox33.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
                terms_agree_3_1 = 0;
            }
        });

        termsBinding.checkbox32.setOnClickListener(view -> {
            if(termsBinding.checkbox32.isChecked()){
                termsBinding.checkbox3.setChecked(true);
                terms_agree_3_2 = 1;
            } else {
                if(!termsBinding.checkbox31.isChecked() && !termsBinding.checkbox33.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
                terms_agree_3_2 = 0;
            }
        });

        termsBinding.checkbox33.setOnClickListener(view -> {
            if(termsBinding.checkbox33.isChecked()){
                termsBinding.checkbox3.setChecked(true);
                terms_agree_3_3 = 1;
            } else {
                if(!termsBinding.checkbox31.isChecked() && !termsBinding.checkbox32.isChecked()){
                    termsBinding.checkbox3.setChecked(false);
                    termsBinding.checkbox1.setChecked(false);
                }
                terms_agree_3_3 = 0;
            }
        });

        termsBinding.buttonContinueRegister.setOnClickListener(view -> {
            Intent intent_continue_register = new Intent(getApplicationContext(), AuthenticationActivity.class);
            startActivity(intent_continue_register);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        termsBinding = null;
    }
}
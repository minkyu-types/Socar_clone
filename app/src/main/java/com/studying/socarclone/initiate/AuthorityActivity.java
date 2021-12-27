package com.studying.socarclone.initiate;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.studying.socarclone.R;

public class AuthorityActivity extends AppCompatActivity {
    TextView textview_confirm;

    @RequiresApi(api = 31)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority);

        textview_confirm = findViewById(R.id.textview_confirm);
        textview_confirm.setOnClickListener(view -> {
            checkSelfPermission();
        });
    }

    // 권한에 대한 응답이 있을 때 동작하는 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 권한 허용했을 경우
        if(requestCode == 1){
            int length = permissions.length;

            for(int i=0; i<length; i++){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    // 동의
                    Log.d("AuthenticationActivity", "권한 허용: " + permissions[i]);
                }
            }
        }
    }

    // 권한 설정 체크
    public void checkSelfPermission(){
        String temp = "";

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED){
            temp += Manifest.permission.READ_PHONE_NUMBERS + " ";
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            temp += Manifest.permission.CAMERA + " ";
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            temp += Manifest.permission.ACCESS_FINE_LOCATION + " ";
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " ";
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            temp += Manifest.permission.READ_EXTERNAL_STORAGE + " ";
        }

        if(!TextUtils.isEmpty(temp)){
            // 권한요청
            ActivityCompat.requestPermissions(this, temp.trim().split(" "), 1);
        } else {
            // 모두 허용 상태
            Toast.makeText(this, "권한 모두 허용됨", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
        }
    }
}
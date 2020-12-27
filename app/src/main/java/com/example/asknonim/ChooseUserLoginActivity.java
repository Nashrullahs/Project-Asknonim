package com.example.asknonim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserLoginActivity extends AppCompatActivity {

    //Tampilan(views)
    Button mLoginBtn, mLoginBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_login);

        //init views

        mLoginBtn = findViewById(R.id.login_btn);
        mLoginBtn2 = findViewById(R.id.login2_btn);

        //handle register button click
        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(ChooseUserLoginActivity.this, LoginActivity.class));
            }
        });
        //handle register mahasiswa button click
        mLoginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start login activity
                startActivity(new Intent(ChooseUserLoginActivity.this, Login2Activity.class));
            }
        });

    }
}
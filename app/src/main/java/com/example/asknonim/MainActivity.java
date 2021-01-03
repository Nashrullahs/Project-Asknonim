package com.example.asknonim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //Tampilan(views)
    Button mChooseUserBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        mChooseUserBtn = findViewById(R.id.chooseUser_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle register button click
        mChooseUserBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(MainActivity.this, ChooseUserRegisterActivity.class));
            }
        });
        //handle login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start login activity
                startActivity(new Intent(MainActivity.this, ChooseUserLoginActivity.class));
            }
        });
    }
}
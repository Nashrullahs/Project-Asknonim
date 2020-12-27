package com.example.asknonim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserActivity extends AppCompatActivity {

    //Tampilan(views)
    Button mRegisterBtn, mRegisterBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        //init views

        mRegisterBtn = findViewById(R.id.register_btn);
        mRegisterBtn2 = findViewById(R.id.login_btn);

        //handle register button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(ChooseUserActivity.this, RegisterActivity.class));
            }
        });
        //handle login button
        //mRegisterBtn2.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
                //start login activity
              //  startActivity(new Intent(ChooseUserActivity.this, LoginActivity.class));
          //  }
        //});
    }
}
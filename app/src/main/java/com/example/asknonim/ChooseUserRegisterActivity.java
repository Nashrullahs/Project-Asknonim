package com.example.asknonim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserRegisterActivity extends AppCompatActivity {

    //Tampilan(views)
    Button mRegisterBtn, mRegisterBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        //init views

        mRegisterBtn = findViewById(R.id.register_btn);
        mRegisterBtn2 = findViewById(R.id.register2_btn);

        //enable back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //handle register button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(ChooseUserRegisterActivity.this, RegisterActivity.class));
            }
        });
        //handle register mahasiswa button click
        mRegisterBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start login activity
                startActivity(new Intent(ChooseUserRegisterActivity.this, Register2Activity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity
        return super.onSupportNavigateUp();
    }
}
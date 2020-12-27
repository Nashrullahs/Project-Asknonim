<<<<<<< HEAD
package com.example.asknonim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

    //Tampilan(views)
    Button mRegisterBtn, mLoginBtn;
=======

public class MainActivity extends AppCompatActivity {
    //Tampilan(views)
    Button mChooseUserBtn, mLoginBtn;
>>>>>>> master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
<<<<<<< HEAD
        mRegisterBtn = findViewById(R.id.register_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle register button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
=======

        mChooseUserBtn = findViewById(R.id.chooseUser_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle register button click
        mChooseUserBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                //start register activity
                startActivity(new Intent(MainActivity.this, ChooseUserActivity.class));
>>>>>>> master
            }
        });
        //handle login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start login activity
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
=======
package com.example.asknonim;

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
<<<<<<< HEAD
>>>>>>> 1804111010065
=======
>>>>>>> 1804111010061
>>>>>>> master
}
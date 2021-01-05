<<<<<<< HEAD
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
=======
package com.example.asknonim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    //Tampilan(views)
    Button mChooseUserBtn, mLoginBtn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        firebaseAuth = FirebaseAuth.getInstance();
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
    private void checkUserStatus(){
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("User");
            userRef.orderByChild("uid").equalTo(user.getUid())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                                String z_name=snapshot.child("level").getValue().toString();
                                if (z_name.equals("Anonim")){
                                    startActivity(new Intent(MainActivity.this, Dashboard2Activity.class));
                                    finish();
                                }else{
                                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                                    finish();
                                }

                            }

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
        }
        else {
            //user not signed in,go to main activity

        }
    }
    @Override
    protected void onStart() {
        //check on start of app
        super.onStart();
        checkUserStatus();
    }
>>>>>>> 1804111010065
}
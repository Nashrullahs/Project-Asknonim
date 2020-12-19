package com.example.asknonim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class GroupChatActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private String groupId;

    private Toolbar toolbar;
    private ImageView groupIconIv;
    private ImageButton attachBtn,sendBtn;
    private TextView groupTitleTv;
    private EditText messageEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        //init views
        toolbar = findViewById(R.id.toolbar);
        groupIconIv = findViewById(R.id.groupIconIv);
        groupTitleTv = findViewById(R.id.groupTitleTv);
        attachBtn = findViewById(R.id.attachBtn);
        messageEt = findViewById(R.id.messageEt);
        sendBtn = findViewById(R.id.sendBtn);

        //get id of the group
        Intent intent = getIntent();
        groupId = intent.getStringExtra("groupId");
        
        firebaseAuth = FirebaseAuth.getInstance();
        loadGroupInfo();
    }

    private void loadGroupInfo() {

    }
}
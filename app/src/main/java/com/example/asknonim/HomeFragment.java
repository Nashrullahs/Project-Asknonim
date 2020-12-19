package com.example.asknonim;

import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView groupsRv;

    private FirebaseAuth firebaseAuth;

    private ArrayList<ModelGroupChatsList>groupChatsLists;
    private AdapterGroupChatList adapterGroupChatList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        groupsRv = view.findViewById(R.id.groupsRv);

        firebaseAuth = FirebaseAuth.getInstance();

        loadGroupChatList();

        return view;
    }

    private void loadGroupChatList(){
        groupChatsLists = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Groups");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                groupChatsLists.size();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    //if current user's uid exists in participants list of group then show that group
                    if (ds.child("Participants").child(firebaseAuth.getUid()).exists()){
                        ModelGroupChatsList model = ds.getValue(ModelGroupChatsList.class);
                        groupChatsLists.add(model);
                    }
                }
                adapterGroupChatList = new AdapterGroupChatList(getActivity(),groupChatsLists);
                groupsRv.setAdapter(adapterGroupChatList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void searchGroupChatList(String query){
        groupChatsLists = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Groups");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                groupChatsLists.size();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    //if current user's uid exists in participants list of group then show that group
                    if (ds.child("Participants").child(firebaseAuth.getUid()).exists()){

                        //search group title
                        if (ds.child("groupTitle").toString().toLowerCase().contains(query.toLowerCase())){
                            ModelGroupChatsList model = ds.getValue(ModelGroupChatsList.class);
                            groupChatsLists.add(model);
                        }

                    }
                }
                adapterGroupChatList = new AdapterGroupChatList(getActivity(),groupChatsLists);
                groupsRv.setAdapter(adapterGroupChatList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
package com.example.asknonim;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterParticipantAdd extends RecyclerView.Adapter<AdapterParticipantAdd.HolderParticipantAdd> {

    private Context context;
    private ArrayList<ModelUser> userList;
    private String groupId, myGroupRole; //creator/admin/participant

    public AdapterParticipantAdd(Context context, ArrayList<ModelUser> userList, String groupId, String myGroupRole) {
        this.context = context;
        this.userList = userList;
        this.groupId = groupId;
        this.myGroupRole = myGroupRole;
    }

    @NonNull
    @Override
    public HolderParticipantAdd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_participant_add, parent, false);
        return new HolderParticipantAdd(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderParticipantAdd holder, int position) {
        //get data
        ModelUser modelUser = userList.get(position);
        String name = modelUser.getName();
        String email = modelUser.getEmail();
        String image = modelUser.getImage();
        String uid = modelUser.getUid();

        //set data
        holder.nameTv.setText(name);
        holder.emailTv.setText(email);
        try {
            Picasso.get().load(image).placeholder(R.drawable.ic_default_img).into(holder.avatarIv);
        }
        catch (Exception e){
            holder.avatarIv.setImageResource(R.drawable.ic_default_img);
        }


        checkIfAlreadyExists(modelUser, holder);

        //handle click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*check if user already added or not
                if added : show remove-participant/make admin/remove admin option
                if not added : show add participant option*/
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Groups");
                ref.child(groupId).child("Participants").child(uid)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()){
                                    //user exists/participant
                                    String hisPreviousRole = ""+dataSnapshot.child("role").getValue();

                                    //options to display in dialog
                                    String[] options = new String[0];

                                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                    builder.setTitle("Choose Option");
                                    if (myGroupRole.equals("creator")){
                                        if (hisPreviousRole.equals("admin")){
                                            //im creator, he is admin
                                            options = new String[]{"Remove Admin", "Remove User"};
                                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int which) {
                                                    //handle item clicks
                                                    if (which == 0){
                                                        //Remove Admin clicked
                                                        removeAdmin(modelUser);
                                                    }
                                                    else {
                                                        //Remove User clicked
                                                        removeParticipant(modelUser);
                                                    }
                                                }
                                            }).show();
                                        }
                                        else if (hisPreviousRole.equals("participant")){
                                            //im creator, he is participant
                                            options = new String[]{"Make Admin", "Remove User"};
                                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int which) {
                                                    //handle item clicks
                                                    if (which == 0){
                                                        //Remove Admin clicked
                                                        makeAdmin(modelUser);
                                                    }
                                                    else {
                                                        //Remove User clicked
                                                        removeParticipant(modelUser);
                                                    }
                                                }
                                            }).show();
                                        }
                                    }
                                    else if (myGroupRole.equals("admin")){
                                        if (hisPreviousRole.equals("creator")){
                                            //im admin, he is creator
                                            Toast.makeText(context, "Creator of Group...", Toast.LENGTH_SHORT).show();
                                        }
                                        else if (hisPreviousRole.equals("admin")){
                                            //im admin, he is admin too
                                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int which) {
                                                    //handle item clicks
                                                    if (which == 0){
                                                        //Remove Admin clicked
                                                        removeAdmin(modelUser);
                                                    }
                                                    else {
                                                        //Remove User clicked
                                                        removeParticipant(modelUser);
                                                    }
                                                }
                                            }).show();
                                        }
                                        else if (hisPreviousRole.equals("participant")){
                                            //im admin, he is participant
                                            options = new String[]{"Make Admin", "Remove User"};
                                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int which) {
                                                    //handle item clicks
                                                    if (which == 0){
                                                        //Remove Admin clicked
                                                        makeAdmin(modelUser);
                                                    }
                                                    else {
                                                        //Remove User clicked
                                                        removeParticipant(modelUser);
                                                    }
                                                }
                                            }).show();
                                        }
                                    }
                                }
                                else {
                                    //user doesn't exists/not-participant: add
                                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                    builder.setTitle("Add Participant")
                                            .setMessage("Add this user in this group?")
                                            .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //add user
                                                    addParticipant(modelUser);
                                                }
                                            })
                                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

            }
        });

    }

    private void addParticipant(ModelUser modelUser) {
    }

    private void makeAdmin(ModelUser modelUser) {
    }

    private void removeParticipant(ModelUser modelUser) {
    }

    private void removeAdmin(ModelUser modelUser) {
    }

    private void checkIfAlreadyExists(ModelUser modelUser, HolderParticipantAdd holder) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Groups");
        ref.child(groupId).child("Participants").child(modelUser.getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            //already exists
                            String hisRole = ""+dataSnapshot.child("role").getValue();
                            holder.statusTv.setText(hisRole);
                        }
                        else
                            //doesn't exists
                        holder.statusTv.setText("");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class HolderParticipantAdd extends RecyclerView.ViewHolder{

        private ImageView avatarIv;
        private TextView nameTv, emailTv, statusTv;



        public HolderParticipantAdd(@NonNull View itemView) {
            super(itemView);

            avatarIv = itemView.findViewById(R.id.avatarIv);
            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            statusTv = itemView.findViewById(R.id.statusTv);
        }
    }
}

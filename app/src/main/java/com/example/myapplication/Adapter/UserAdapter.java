package com.example.myapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.SecondScreen;
import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<User> listUser;

    public UserAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_listview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.firstname.setText(listUser.get(position).getFirst_name());
        holder.lastName.setText(listUser.get(position).getLast_name());
        holder.email.setText(listUser.get(position).getEmail());

        Glide.with(holder.itemView.getContext())
                .load(listUser.get(position).getAvatar())
                .into(holder.avatar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondScreen.class);
                intent.putExtra("nameFromList", listUser.get(position).getFirst_name());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView firstname, lastName, email;
        public ImageView avatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.tv_firstName);
            lastName = itemView.findViewById(R.id.tv_lastName);
            email = itemView.findViewById(R.id.tv_email);
            avatar = itemView.findViewById(R.id.list_img);
        }
    }
}

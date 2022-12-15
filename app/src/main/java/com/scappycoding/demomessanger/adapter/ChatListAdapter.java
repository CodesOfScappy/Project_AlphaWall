package com.scappycoding.demomessanger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.scappycoding.demomessanger.R;
import com.scappycoding.demomessanger.model.ChatList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {

    private List<ChatList> list;
    private Context context;


    public ChatListAdapter(List<ChatList> list, Context context) {
        this.list = list;
        this.context = context;

    }



    @NonNull
    @Override
    // This Methode Create a new Element view HolderAdapter to inflate the view Element
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chat_list,parent,false);

        return new Holder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.Holder holder, int position) {

        ChatList chatList = list.get(position);

        holder.tvName.setText(chatList.getUserName());
        holder.tvDesc.setText(chatList.getDescription());
        holder.tvDate.setText(chatList.getDate());

        //Glide Dependency/// This imported the User profile Image
        Glide.with(context).load(chatList.getUriProfile()).into(holder.profile);


    }





    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView tvName,tvDesc,tvDate;
        private CircleImageView profile;

        public Holder(@NonNull View itemView) {
            super(itemView);


            tvName = itemView.findViewById(R.id.tvUsername);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvDate = itemView.findViewById(R.id.tvDate);
            profile = itemView.findViewById(R.id.image_profile);
        }
    }
}

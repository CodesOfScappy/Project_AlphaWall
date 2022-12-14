package com.scappycoding.demomessanger.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.scappycoding.demomessanger.R;
import com.scappycoding.demomessanger.model.CallList;
import com.scappycoding.demomessanger.model.ChatList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallListAdapter  extends RecyclerView.Adapter<CallListAdapter.Holder> {
    private List<CallList> list;
    private Context context;


    public CallListAdapter(List<CallList> list, Context context) {
        this.list = list;
        this.context = context;

    }



    @NonNull
    @Override
    // This Methode Create a new Element view HolderAdapter to inflate the view Element
    public CallListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_call_list,parent,false);

        return new CallListAdapter.Holder(view);
    }



    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull CallListAdapter.Holder holder, int position) {

        CallList callList = list.get(position);

        holder.tvName.setText(callList.getUserName());
        holder.tvDate.setText(callList.getDate());


        if (callList.getCallType().equals("missed"))
        {
            holder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_downward));
            holder.arrow.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_red_dark));
        }
        else if (callList.getCallType().equals("income"))
        {
            holder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_downward));
            holder.arrow.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }
        else
        {
            holder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_arrow_upward));
            holder.arrow.getDrawable().setTint(context.getResources().getColor(android.R.color.holo_green_dark));
        }

        //Glide Dependency/// This imported the User profile Image
        Glide.with(context).load(callList.getUriProfile()).into(holder.profile);



    }





    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView tvName,tvDate;
        private CircleImageView profile;
        private ImageView arrow;

        public Holder(@NonNull View itemView) {
            super(itemView);


            tvName = itemView.findViewById(R.id.tvUsername);
            tvDate = itemView.findViewById(R.id.tvDate);
            profile = itemView.findViewById(R.id.image_profile);
            arrow = itemView.findViewById(R.id.image_arrow);

        }
    }
}

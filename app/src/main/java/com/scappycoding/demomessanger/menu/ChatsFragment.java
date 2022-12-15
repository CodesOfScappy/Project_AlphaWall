package com.scappycoding.demomessanger.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scappycoding.demomessanger.R;
import com.scappycoding.demomessanger.adapter.ChatListAdapter;
import com.scappycoding.demomessanger.model.ChatList;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {



    public ChatsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        List<ChatList> list = new ArrayList<>();
        RecyclerView  recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Demo Messenger-User Profile
        //TODO: insert the User-Model and Delete the Demo-Users!
        list.add(new ChatList("001",
                "DemoUser",
                "Description",
                "13.12.2022",
                "https://firebasestorage.googleapis.com/v0/b/messanger-8cac3.appspot.com/o/profile_pic%2Fgcp4SA3lG2OlpKV7fTt6AMnFYNE2?alt=media&token=5677ef8c-500d-4c17-b105-8104bfd96120"));

        list.add(new ChatList("002",
                "DemoUser2",
                "MyStatus",
                "12.12.2022",
                "https://lh3.googleusercontent.com/a/AEdFTp69JuB4pN_VKAeKjKAg3yc4SljA23hxj7xsc9ju=s96-c"));

        list.add(new ChatList("003",
                "DemoUser3",
                "MyStatus",
                "12.12.2022",
                "https://lh3.googleusercontent.com/a/AEdFTp69JuB4pN_VKAeKjKAg3yc4SljA23hxj7xsc9ju=s96-c"));

        recyclerView.setAdapter(new ChatListAdapter(list,getContext()));
        return view;
    }


}
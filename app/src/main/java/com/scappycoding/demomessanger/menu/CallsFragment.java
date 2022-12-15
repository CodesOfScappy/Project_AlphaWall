package com.scappycoding.demomessanger.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scappycoding.demomessanger.R;
import com.scappycoding.demomessanger.adapter.CallListAdapter;
import com.scappycoding.demomessanger.model.CallList;

import java.util.ArrayList;
import java.util.List;


public class CallsFragment extends Fragment {


    public CallsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_calls,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<CallList> lists = new ArrayList<>();

        // Demo User in CallList
        //TODO: Change in Final this to CallUser Model
        lists.add(new CallList("001",
                "DemoUser",
                "14.12.2022, 9:40",
                "https://firebasestorage.googleapis.com/v0/b/messanger-8cac3.appspot.com/o/profile_pic%2Fgcp4SA3lG2OlpKV7fTt6AMnFYNE2?alt=media&token=5677ef8c-500d-4c17-b105-8104bfd96120","income"));
        lists.add(new CallList("002",
                "DemoUser2",
                "14.12.2022, 9:30",
                "https://lh3.googleusercontent.com/a/AEdFTp69JuB4pN_VKAeKjKAg3yc4SljA23hxj7xsc9ju=s96-c","missed"));


        recyclerView.setAdapter(new CallListAdapter(lists,getContext()));
    return view;
    }
}
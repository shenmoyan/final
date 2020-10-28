package com.example.finalapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FoodFragment extends Fragment {
    private String context2;
    private TextView mTextView;

    public  FoodFragment(String context){
        this.context2 = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food,container,false);
        mTextView = (TextView)view.findViewById(R.id.txt_content2);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        mTextView.setText(context2);
        return view;
    }
}


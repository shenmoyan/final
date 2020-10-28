package com.example.finalapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookFragment extends Fragment {
    private String context3;
    private TextView mTextView;

    public  BookFragment(String context){
        this.context3 = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book,container,false);
        mTextView = (TextView)view.findViewById(R.id.txt_content3);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        mTextView.setText(context3);
        return view;
    }
}


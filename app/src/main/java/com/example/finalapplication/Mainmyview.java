package com.example.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Mainmyview extends AppCompatActivity {
    int[] images = new int[]{
            R.drawable.p_6, //替换为自己的图片名称
            R.drawable.p_7,
            R.drawable.p_8,
            R.drawable.p_9,
            R.drawable.p_8,
            R.drawable.p_9 ,
            R.drawable.p_1,
    };
    int currentImg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmyview);

        LinearLayout main =  (LinearLayout)findViewById(R.id.root);

        final ImageView image = new ImageView(this);

        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(images[++currentImg % images.length]);
            }
        });


    }
}


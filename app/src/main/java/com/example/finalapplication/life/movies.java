package com.example.finalapplication.life;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.finalapplication.R;

import java.util.ArrayList;
import java.util.List;

public class movies extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFruits();
        setContentView(R.layout.activity_movies);
        FruitAdapter adapter = new FruitAdapter(movies.this, R.layout.activity_movies_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits() {
        Fruit apple = new Fruit("街头涂鸦", R.drawable.p_10);
        fruitList.add(apple);
        Fruit banana = new Fruit("街舞", R.drawable.p_4);
        fruitList.add(banana);
        Fruit orange = new Fruit("说唱", R.drawable.p_5);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.p_1);
        fruitList.add(watermelon);
    }
}


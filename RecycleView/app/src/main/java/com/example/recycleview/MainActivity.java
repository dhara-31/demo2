package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ArrayList letter = new ArrayList<>(Arrays.asList("dhara", "pqr", "xyz", "opq", "rst"));
    ArrayList myimage = new ArrayList<>(Arrays.asList(R.drawable.d,R.drawable.d1,R.drawable.d3,R.drawable.download,R.drawable.image))

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView  rview = (RecyclerView) findViewById(R.id.recycle);

        LinearLayoutManager ll= new LinearLayoutManager(getApplicationContext());
        rview.setLayoutManager(ll);

        CustomAdapter ca = new CustomAdapter(MainActivity.this,letter);
        rview.setAdapter(ca);

    }
}

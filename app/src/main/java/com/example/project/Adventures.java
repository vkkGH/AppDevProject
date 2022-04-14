package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Adventures extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String[] destinationsName = {"Mykonos", "Paris", "Toronto", "NewYork"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, destinationsName);
        recyclerView.setAdapter(adapter);
    }
}
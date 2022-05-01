package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Recycler extends AppCompatActivity implements ListenerInterface  { // new
    RecyclerView recyclerView;
    private DatabaseReference database;
    private ArrayList<Destination> destinationsList;
    private RecyclerAdapter recyclerAdapter;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(Recycler.this, R.color.black));
        recyclerView = findViewById(R.id.destinations);
        database = FirebaseDatabase.getInstance().getReference("Locations");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        destinationsList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(this, destinationsList, this);
        recyclerView.setAdapter(recyclerAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Destination destination = dataSnapshot.getValue(Destination.class);
                    destinationsList.add(destination);

                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @Override
    public void onItemClick(int position) {     // new

        Intent intent = new Intent(Recycler.this, DestinationPage.class);
        intent.putExtra("Image", destinationsList.get(position).getImageUrl());
        intent.putExtra("Name", destinationsList.get(position).getLocation_name());
        intent.putExtra("Price", destinationsList.get(position).getPrice());
        startActivity(intent);
        finish();
    }
}

package com.example.project;

import android.content.Context;
import android.os.Bundle;

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

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
   // FirebaseDatabase database = FirebaseDatabase.getInstance();
   // private DatabaseReference reference;
    private DatabaseReference database;
    private ArrayList<Destination> destinationsList;
    private RecyclerAdapter recyclerAdapter;
   // private Context context;



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
        recyclerAdapter = new RecyclerAdapter(this, destinationsList);
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

        /*
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Locations");
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(Recycler.this, R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerAdapter = new RecyclerAdapter(this.getApplicationContext(), destinationsList);
        recyclerView = findViewById(R.id.destinations);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);
        destinationsList = new ArrayList<>();
        ClearAll();
        GetFirebaseLocationData();

         */
    }
    /*
    private void GetFirebaseLocationData() {
        Query query = reference.child("Locations");
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Destination destinations = new Destination();
                    destinations.setImage(snapshot.child("imageUrl").getValue().toString());
                    destinations.setName(snapshot.child("location_name").getValue().toString());
                   // destinations.setPrice(Double.parseDouble((String) Objects.requireNonNull(snapshot.child("price").getValue())));
                    destinationsList.add(destinations);
                }

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), destinationsList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ClearAll() {
        if (destinationsList != null) {
            destinationsList.clear();
            if (recyclerAdapter != null) {
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        destinationsList = new ArrayList<>();
    }

     */
}

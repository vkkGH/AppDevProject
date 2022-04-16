package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.ModelLoader;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<Locations> options;
    FirebaseRecyclerAdapter<Locations, MyViewHolder> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Locations");
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        LoadData();




    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<Locations>().setQuery(databaseReference, Locations.class).build();
        adapter = new FirebaseRecyclerAdapter<Locations, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull Locations model) {
                holder.textView.setText(model.getPrice());
                holder.textView2.setText(model.getLocation_name());
                Picasso.get().load(model.getImageUrl()).into(holder.imageView);

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Recycler.this, ViewDestination.class);
                        intent.putExtra("MiamiKey", getRef(position).getKey());
                        startActivity(intent);

                    }
                });
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adventures, parent, false);
                return new MyViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }

}

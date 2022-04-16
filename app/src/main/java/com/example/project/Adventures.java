package com.example.project;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adventures extends AppCompatActivity {
    String[] adventuresNamesList = {"Mexico","Bulgaria","Japan"};
    //ArrayList<String> adventuresNamesList = new ArrayList<>();
    FirebaseRecyclerOptions<AdventuresModels> options;
    FirebaseRecyclerAdapter<AdventuresModels,ViewHolder>adapter;
    DatabaseReference Dataref;
    RecyclerView recyclerView;

    ArrayList<AdventuresModels> adventuresModels = new ArrayList<>();

    /*
    private void setUpAdventures(){
        //String[] adventuresNames = (String[]) adventuresNamesList.toArray();
        String[] adventuresNames = adventuresNamesList;
        for(int i = 0; i<adventuresNames.length;i++){
            adventuresModels.add(new AdventuresModels(adventuresNames[i]));
        }
    }
    */

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvAdventureName;
        //tvPrice, tvAdventureDescription;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            imageView = itemView.findViewById(R.id.adventureImage);
            tvAdventureName = itemView.findViewById(R.id.adventureName);
            //tvPrice = itemView.findViewById(R.id.price);
            //tvAdventureDescription = itemView.findViewById(R.id.adventureDescription);

            //textView = itemView.findViewById(R.id.destinationNames);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventures);
        Dataref = FirebaseDatabase.getInstance().getReference().child("Locations");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        //setUpAdventures();
        LoadData();
        /*
        RecyclerAdapter adapter = new RecyclerAdapter(this, adventuresModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Destination_name");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adventuresNamesList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    adventuresNamesList.add(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        */

    }
    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<AdventuresModels>().setQuery(Dataref, AdventuresModels.class).build();
        adapter = new FirebaseRecyclerAdapter<AdventuresModels, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull AdventuresModels model) {
                holder.tvAdventureName.setText(model.getDestinationName());
                Picasso.get().load(model.getImage()).into(holder.imageView);
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.adventures_layout, parent, false);
                return new ViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }



}

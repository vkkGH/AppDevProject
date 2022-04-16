package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ViewDestination extends AppCompatActivity {

    private ImageView imageView;
    TextView textView, textView2, textView3;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_destination);

        imageView = findViewById(R.id.image_adventures_view_activity);
        textView = findViewById(R.id.textView_adventures_view_activity);
        textView2 = findViewById(R.id.textView_adventures_view2_activity);
        textView3 = findViewById(R.id.textView_adventures_view3_activity);
        ref = FirebaseDatabase.getInstance().getReference().child("Locations");

        String LocationsKey = getIntent().getStringExtra("MiamiKey");

        ref.child(LocationsKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String location_name = snapshot.child("location_name").getValue().toString();
                    String price = snapshot.child("price").getValue().toString();
                    String imageUrl = snapshot.child("imageUrl").getValue().toString();

                    Picasso.get().load(imageUrl).into(imageView);
                    textView.setText(location_name);
                    textView2.setText(price);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}
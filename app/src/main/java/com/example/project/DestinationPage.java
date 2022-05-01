package com.example.project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;

import org.w3c.dom.Text;

import java.net.URI;

public class DestinationPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(DestinationPage.this, R.color.black));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        String name = getIntent().getStringExtra("Name");
        String price = getIntent().getStringExtra("Price");
        String image = String.valueOf(getIntent().getStringExtra("Image"));


        TextView nameView = findViewById(R.id.destinationName);
        TextView priceView = findViewById(R.id.priceView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        nameView.setText(name);
        priceView.setText(price);
        Glide.with(this).load(image).into(imageView);
    }
}

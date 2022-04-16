package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AdventuresModels  {

    String destinationName;
    String image;

    //RecyclerView recyclerView;
    //RecyclerAdapter adapter;
    public AdventuresModels(String destinationName, String image) {
        this.destinationName = destinationName;
        this.image = image;
    }


    //String[] destinationsName = {"Mykonos", "Paris", "Toronto", "NewYork"};


    public String getDestinationName() {
        return destinationName;
    }

    public String getImage() {
        return image;
    }
}
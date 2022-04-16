package com.example.project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context destinationContext;
    ArrayList<Destination> destinationsList;

    public RecyclerAdapter(Context destinationContext, ArrayList<Destination> destinationsList) {
        this.destinationContext = destinationContext;
        this.destinationsList = destinationsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adventures, parent, false);
        //View view = LayoutInflater.from(destinationContext).inflate(R.layout.activity_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Destination destination = destinationsList.get(position);
        holder.destinationName.setText(String.valueOf(destination.getLocation_name()));
        holder.destinationPrice.setText(String.valueOf(destination.getPrice()));
       //Glide.with(destinationContext).load(destination.getImage().into(holder.destinationImage));

       // holder.destinationName.setText(destinationsList.get(position).getName());
        //holder.destinationPrice.setText(String.valueOf(destinationsList.get(position).getPrice()));

        //Glide.with(destinationContext).load(destinationsList.get(position).getImage()).into(holder.destinationImage);



    }

    @Override
    public int getItemCount() {

        return destinationsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView destinationImage;
        TextView destinationName;
        TextView destinationPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationImage = itemView.findViewById(R.id.destinationImageView);
            destinationName = itemView.findViewById(R.id.destinationNameView);
            destinationPrice = itemView.findViewById(R.id.destinationPriceView);
        }
    }



}
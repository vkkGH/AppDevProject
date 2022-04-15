package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;

    ArrayList<Location> list;

    public RecyclerAdapter(Context context, ArrayList<Location> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.destinations, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location location = list.get(position);

//        holder.images.set);
        holder.price.setText(location.getPrice());
        holder.location_name.setText(location.getLocation_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

//        ImageView images;
        TextView price;
        TextView location_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            images = itemView.findViewById(R.id.dt_images);
            price = itemView.findViewById(R.id.dt_price);
            location_name = itemView.findViewById(R.id.dt_locationName);
        }
    }


}

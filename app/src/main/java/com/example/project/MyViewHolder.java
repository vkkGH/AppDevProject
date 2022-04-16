package com.example.project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView, imageView2;
    TextView textView, textView2, textView3;
    View v;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_adventures_view);
        textView = itemView.findViewById(R.id.textView_adventures_view);
        textView2 = itemView.findViewById(R.id.textView_adventures_view2);
//        textView3 = itemView.findViewById(R.id.textView_adventures_view3);
        v = itemView;
    }
}

package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
<<<<<<< Updated upstream
=======
        btn = findViewById(R.id.button);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AdventuresModels.class);
            startActivity(intent);
        });
>>>>>>> Stashed changes
    }
}
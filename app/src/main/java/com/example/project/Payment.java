package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    private Button btn;
    EditText fullName, cardNumber, CVV, date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn = findViewById(R.id.payment);
        fullName = findViewById(R.id.EditTextFullName);
        cardNumber = findViewById(R.id.EditTextCardNumber);
        CVV = findViewById(R.id.EditTextCVV);
        date = findViewById(R.id.EditTextDate);

        fullName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theFullName;
                theFullName = fullName.getText().toString();
                if(theFullName.isEmpty()) {
                    Toast.makeText(Payment.this, "Cannot leave blank", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cardNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theCardNumber;
                theCardNumber = cardNumber.getText().toString();
                if(theCardNumber.isEmpty()) {
                    Toast.makeText(Payment.this, "Cannot leave blank", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CVV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theCVV;
                theCVV = CVV.getText().toString();
                if(theCVV.isEmpty()) {
                    Toast.makeText(Payment.this, "Cannot leave blank", Toast.LENGTH_SHORT).show();
                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theDate;
                theDate = date.getText().toString();
                if(theDate.isEmpty()) {
                    Toast.makeText(Payment.this, "Cannot leave blank", Toast.LENGTH_SHORT).show();
                }
            }
        });
        

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Success.class);
            startActivity(intent);
        });

    }
}
package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard_Page extends AppCompatActivity {

    Button profile,pan,adhar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__page);


    pan=findViewById(R.id.button4);
    profile=findViewById(R.id.button2);
    adhar=findViewById(R.id.button5);

    profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent profile=new Intent(Dashboard_Page.this,Profile_Activity.class);
            startActivity(profile);
        }
    });

        adhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adhar=new Intent(Dashboard_Page.this,Adhar_verification.class);
                startActivity(adhar);
            }
        });



        pan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent pan=new Intent(Dashboard_Page.this,Pan_Verification.class);
            startActivity(pan);
        }
    });

    }
}
package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Getting_Started extends AppCompatActivity {

    TextView t1;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting__started);

        t1=findViewById(R.id.textview21);
        login=findViewById(R.id.loginbtn);
        signup=findViewById(R.id.registerbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login1=new Intent(Getting_Started.this,Login_page.class);
                startActivity(login1);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register=new Intent(Getting_Started.this,Registration_Page.class);
                startActivity(register);
            }
        });
    }
}
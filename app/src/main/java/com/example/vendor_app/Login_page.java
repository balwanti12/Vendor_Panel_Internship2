package com.example.vendor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {

    Myhelper mh;

    EditText e1,e2;
    Button b1;
    TextView t1;

    Boolean EditTextEmptyHolder;
    String TempPassword = "NOT_FOUND" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mh=new Myhelper(this);
        setContentView(R.layout.activity_login_page);

        e1=findViewById(R.id.editTextPhone3);
        e2=findViewById(R.id.editTextTextPassword);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.textView4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mobile = e1.getText().toString();

                String Password = e2.getText().toString();

                if (TextUtils.isEmpty(Mobile) || TextUtils.isEmpty(Password)) {

                    EditTextEmptyHolder = false;
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();

                } else {

                    EditTextEmptyHolder = true;
                    String TempPassword=mh.getSinlgeEntry(Mobile);

                    if(TempPassword.equals(Password)) {

                        Toast.makeText(Login_page.this, "Login Successfully", Toast.LENGTH_LONG).show();
                        Intent dashboard=new Intent(Login_page.this,Dashboard_Page.class);
                        startActivity(dashboard);
                        /*Intent i = new Intent(MainActivity.this, Profile.class);
                        Bundle b = new Bundle();
                        b.putString("key1", etUser.getText().toString());
                        i.putExtras(b);
                        startActivity(i);*/

// Close The Database
                        mh.close();
                    }
                    else{
                        Toast.makeText(Login_page.this, "Please Enter VAlid Password", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register=new Intent(Login_page.this,Registration_Page.class);
                startActivity(register);
            }
        });
    }
}
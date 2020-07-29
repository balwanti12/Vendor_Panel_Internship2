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

public class Registration_Page extends AppCompatActivity {

    Myhelper mh;

    EditText name,phone,add,pin,email,pass;
    TextView t1;
    Button register;
    boolean EditTextEmptyHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__page);
        mh=new Myhelper(this);

        name=findViewById(R.id.editTextTextPersonName);
        phone=findViewById(R.id.editTextPhone);
        add=findViewById(R.id.editTextTextPostalAddress);
        pin=findViewById(R.id.editTextPhone2);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.editTextTextPassword2);
        register=findViewById(R.id.button3);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username= name.getText().toString();
                String Mobile=phone.getText().toString();
                String Address=add.getText().toString();
                String Pin=pin.getText().toString();
                String Email=email.getText().toString();
                String Password=pass.getText().toString();

                if (TextUtils.isEmpty(Username) || TextUtils.isEmpty(Password)||TextUtils.isEmpty(Mobile) || TextUtils.isEmpty(Pin)
                        || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Address)) {

                    EditTextEmptyHolder = false;
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();


                }
                else{


                    mh.insertRecords(Username,Mobile,Address,Pin,Email,Password);

                    Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_LONG).show();

                    Intent g1=new Intent(Registration_Page.this,Getting_Started.class);
                    startActivity(g1);

                }
            }
        });

    }
}
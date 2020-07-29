package com.example.vendor_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile_Activity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ImageView ChangePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Profile");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        ChangePicture=findViewById(R.id.ChangePictureIv);
        floatingActionButton = findViewById(R.id.fab);

        ChangePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditPicture();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog();
            }
        });
    }

    private void showEditProfileDialog() {
        String options[] = {"Edit Name", "Edit Email", "Edit Phone number","Edit address","Edit PinCode"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Action");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //edit name
                } else if (which == 1) {
                    //edit email
                } else if (which == 2) {
                    //edit phone number
                } else if (which == 3) {
                    //edit address
                }
                else if (which == 4) {
                    //edit PinCode
                }
            }
        });
        builder.create().show();
    }


    private void EditPicture() {
        String options[] = {"Take a photo", "Select a photo from gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Action");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //pick from camera
                } else if (which == 1) {
                    //pick from gallery
                }
            }
        });

        builder.create().show();
    }
}
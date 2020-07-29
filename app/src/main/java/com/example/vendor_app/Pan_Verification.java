package com.example.vendor_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.bumptech.glide.Glide;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class Pan_Verification extends AppCompatActivity {

    Myhelper mh;

    private CircleImageView profile;
    private Dialog loadingDialogue;

    boolean EditTextEmptyHolder;


    private Button conti;
    private ImageView Photo;;
    private EditText etName;
    private EditText etFatherName;
    private EditText etPanCardNumber;
    private EditText etDOB;
    private CircleImageView imgPhoto;
    Button addPhoto;
    private Button saveButton, clearButton;
    SignaturePad signaturePad;

  //  final int PICK_IMAGE = 1;
   // Uri imageUri;





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)


  //  public static TextView BirthdayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan__verification);


        ///////////////////////////////////loading dialogue/////////////////////////////////////////////

        loadingDialogue = new Dialog(this);
        loadingDialogue.setContentView(R.layout.loadingprogressdialogue);
        loadingDialogue.setCancelable(false);
        loadingDialogue.getWindow().setBackgroundDrawable(getDrawable(R.drawable.slider_background));
        loadingDialogue.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


/////////////////////////////////////loading dialogue/////////////////////////////////////////////

        mh=new Myhelper(this);

        etName = findViewById(R.id.nameEt);
        etFatherName = findViewById(R.id.FathernameEt);
        etPanCardNumber = findViewById(R.id.panNumberEt);
        etDOB = findViewById(R.id.editTextDate);
        signaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        clearButton = (Button) findViewById(R.id.clear);
        saveButton = (Button) findViewById(R.id.save);
        addPhoto = findViewById(R.id.addPhoto);
        Photo = findViewById(R.id.photo);
        //   BirthdayTv=(TextView) findViewById(R.id.BirthdayTv);

    //    final AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


//        awesomeValidation.addValidation(this, R.id.etName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

    //    awesomeValidation.addValidation(this, R.id.editTextDate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signature is saved
                Toast.makeText(Pan_Verification.this, "Signature Saved", Toast.LENGTH_SHORT).show();

            }
        });

        imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pan_Verification.this, "camera", Toast.LENGTH_SHORT).show();


                Intent gallery = new Intent();
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), 1);

            }
        });

        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Pan_Name = etName.getText().toString();
                String Father_Name = etFatherName.getText().toString();
                String PanCard_Number = etPanCardNumber.getText().toString();
                String Date_of_Birth= etDOB.getText().toString();


                if (TextUtils.isEmpty(Pan_Name) || TextUtils.isEmpty(PanCard_Number)||TextUtils.isEmpty(Date_of_Birth) || TextUtils.isEmpty(Father_Name)
                        ) {
//

                    Toast.makeText(Pan_Verification.this, "fields are empty", Toast.LENGTH_SHORT).show();
                }

                 else{
                    // Pan Number Validation
                                Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");


                                Matcher matcher = pattern.matcher(PanCard_Number);

                                if (matcher.matches()) {




                                    boolean isInserted = mh.insertRecords1(Pan_Name,PanCard_Number,Date_of_Birth,Father_Name);

                                   if (isInserted) {
                                        Toast.makeText(Pan_Verification.this, "Data Inserted", Toast.LENGTH_SHORT).show();


//

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                startActivity(new Intent(Pan_Verification.this, VerificationActivity.class));
                                                finish();
                                            }
                                        }, 5000);

                                    } else {
                                        Toast.makeText(Pan_Verification.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();


                                    }


                                } else {
                                    loadingDialogue.dismiss();

                                    Toast.makeText(Pan_Verification.this, PanCard_Number + " is Not Matching",
                                            Toast.LENGTH_LONG).show();
                                }


//

                            }

                        }










        });

    }

 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri ImageUri = data.getData();
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Glide.with(this).load(resultUri).into(imgPhoto);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();

                Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
/*
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;


        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
*/
   // public static long getTimeMillis(String dateString, String dateFormat) throws ParseException, java.text.ParseException {
        /*Use date format as according to your need! Ex. - yyyy/MM/dd HH:mm:ss */
    //  String myDate = dateString;//"2017/12/20 18:10:45";
    //  SimpleDateFormat sdf = new SimpleDateFormat(dateFormat/*"yyyy/MM/dd HH:mm:ss"*/);
  /*    Date date = sdf.parse(myDate);
        long millis = date.getTime();

       return millis;
    }
     */


}
package com.example.vendor_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Myhelper extends SQLiteOpenHelper {
    private String Username;

    public Myhelper(@Nullable Context context) {
        super(context, "Vendor", null,1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table User(Username varchar(40), Mobile String primary key ,Address varchar(60),Pin String,Email varchar(40) ," +
                " Password varchar(40) , Pan_Name varchar(50),PanCard_Number String,Date_of_Birth String,Father_Name varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    void insertRecords(String Username, String Mobile,String Address,String Pin, String Email,String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("Username",Username);
        values.put("Mobile",Mobile);
        values.put("Address",Address);
        values.put("Pin",Pin);
        values.put("Email",Email);
        values.put("Password",Password);
        db.insert("User", null, values);
        db.close();

    }

    boolean insertRecords1(String Pan_Name, String PanCard_Number , String Date_of_Birth, String Father_Name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();


        values.put("Pan_Name",Pan_Name);
        values.put("PanCard_Number" ,PanCard_Number);
        values.put("Date_of_Birth",Date_of_Birth);
        values.put("Father_Name",Father_Name);
        db.insert("User", null, values);
        db.close();

        return false;
    }
    public Cursor getRecords()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("Select *from User ",null);
        return c;
    }
    public String getSinlgeEntry(String Mobile)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("User", null, " Mobile=?", new String[]{Mobile}, null, null, null);
        if(cursor.getCount()<1) // mobile Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("Password"));
        cursor.close();
        return password;
    }
}

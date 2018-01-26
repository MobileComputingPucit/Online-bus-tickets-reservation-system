package com.example.imtisal.finalprojectv5;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by IMTISAL on 9/5/2017.
 */

public class DatabaseHelper  extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT,TRAVELLERS INTEGER,DATE DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Upgrade table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String etName, int etMobileNumber, String etEmail, int etTravellers ) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Insert data in table
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", etName);
        contentValues.put("MOBILE_NUMBER", etMobileNumber);
        contentValues.put("EMAIL", etEmail);
        contentValues.put("TRAVELLERS", etTravellers);


        long result = db.insert(TABLE_NAME, null, contentValues);

        db.close();
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        //Get data from table
        String query = "SELECT * FROM " + TABLE_NAME ;

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
    public Cursor getData(String mobile_number) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Get data from table
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE MOBILE_NUMBER = '" + mobile_number + "'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
    public void deleteData(String mobile_number)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        //delete data from table
        db.delete(TABLE_NAME, "MOBILE_NUMBER = '"+mobile_number+"'",null);

        db.close();
    }
    public void updateData( String number,String name, String email,String travellers)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME",name);

        contentValues.put("EMAIL",email);
        contentValues.put("TRAVELLERS",travellers);


        //updating values in database

        db.update(TABLE_NAME, contentValues, "MOBILE_NUMBER = '" + number+"'",null );

        db.close();
    }
}

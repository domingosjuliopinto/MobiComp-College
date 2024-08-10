package com.example.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table Userdetails(name Text primary key, contact Text, dob Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertUserData(String name,String contact,String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Contact",contact);
        contentValues.put("DOB",dob);
        long result = DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean updateUserData(String name,String contact,String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Contact",contact);
        contentValues.put("DOB",dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if (cursor.getCount()>0){
            long result = DB.update("Userdetails",contentValues,"name=?",new String[]{name});
            if (result==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Boolean deleteUserData(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if (cursor.getCount()>0){
            long result = DB.delete("Userdetails","name=?",new String[]{name});
            if (result==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor getUserData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }
}

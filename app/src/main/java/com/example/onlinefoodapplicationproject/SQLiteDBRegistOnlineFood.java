package com.example.onlinefoodapplicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDBRegistOnlineFood extends SQLiteOpenHelper {
    public SQLiteDBRegistOnlineFood(Context context) {
        super(context, "registeruserinfor.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("CREATE TABLE registeruserdetail (name TEXT primary key, phone TEXT, email TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists registeruserdetail");


    }

    public boolean insertdata(String name, String phone, String email, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new  ContentValues();

        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = DB.insert("registeruserdetail", null, contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean updateuserdata (String name, String phone, String email, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Phone", phone);
        contentValues.put("email", email);
        contentValues.put("Password", password);
        Cursor cursor = DB.rawQuery("select * from registeruserdetail where name = ?", new String[] {name});
        if (cursor.getCount()>0) {
            long result = DB.update("registeruserdetail", contentValues, "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {

                return true;
            }
        }else {
            return false;
        }
    }

    public boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("select * from registeruserdetail where name = ?", new String[] {name});
        if (cursor.getCount()>0) {
            long result = DB.delete("registeruserdetail", "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {

                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("select * from registeruserdetail", null);
        return cursor;
    }



}

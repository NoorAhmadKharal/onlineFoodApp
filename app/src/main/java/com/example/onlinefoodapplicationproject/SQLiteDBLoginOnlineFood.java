package com.example.onlinefoodapplicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteDBLoginOnlineFood extends SQLiteOpenHelper {
    public SQLiteDBLoginOnlineFood(Context context) {
        super(context, "onlineFood.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table onlineUserdetail (phone TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists onlineUserdetail");

    }


    public boolean saveOder (String phone, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long result = DB.insert("onlineUserdetail", null, contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {

            return true;
        }
    }


    public boolean insertuserdata (String phone, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long result = DB.insert("onlineUserdetail", null, contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {

            return true;
        }
    }

    public boolean updateuserdata (String phone, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        Cursor cursor = DB.rawQuery("select * from onlineUserdetail where phone = ?", new String[] {phone});
        if (cursor.getCount()>0) {
            long result = DB.update("onlineUserdetail", contentValues, "phone=?", new String[]{phone});

            if (result == -1) {
                return false;
            } else {

                return true;
            }
        }else {
            return false;
        }
    }

    public boolean deletedata (String phone)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("select * from onlineUserdetail where phone = ?", new String[] {phone});
        if (cursor.getCount()>0) {
            long result = DB.delete("onlineUserdetail", "phone=?", new String[]{phone});

            if (result == -1) {
                return false;
            } else {

                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // use when you want create DB run time
        Cursor cursor = DB.rawQuery("select * from onlineUserdetail", null);
        return cursor;
    }
}

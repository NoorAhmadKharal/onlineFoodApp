package com.example.onlinefoodapplicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class placeorder extends SQLiteOpenHelper {
    public static final String ITEM = "placeorder.db";
    public static final String TABLE_NAME = "placeorder.db";

    public static final String COL1 = "item_name";
    public static final String COL2 = "Quantity";
    public static final String COL3 = "total_bill";


    public placeorder(Context context) {
        super(context, ITEM, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE placeorder (item_name TEXT, Quantity NUMBER, total_bill NUMBER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop Table if exists placeorder");
        onCreate(db);

    }
    public boolean insertdata(String item_name, String Quantity, String total_bill)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new  ContentValues();

        contentValues.put("item_name", item_name);
        contentValues.put("Quantity", Quantity);
        contentValues.put("total_bill", total_bill);

        long result1 = db.insert("placeorder", null, contentValues);

        if (result1 == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}

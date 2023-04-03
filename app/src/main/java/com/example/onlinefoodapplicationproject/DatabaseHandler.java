package com.example.onlinefoodapplicationproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OnlineFood2";
    private static final String TABLE_User = "login_User";
    private static final String TABLE_Oder = "food_oder";

    private static final String KEY_ID = "id";
    private static final String KEY_UserName = "user_name";
    private static final String KEY_UserPassword = "user_password";
    private static final String KEY_Email = "user_email";
    private static final String KEY_Phone = "user_phone";
    private static final String KEY_DateTime = "dateTime";


    private static final String KEY_order_id = "order_id";
    private static final String KEY_order_amount = "order_amount";

    private static final String KEY_order_item_name = "order_details_item_name";
    private static final String KEY_order_item_price = "order_details_item_price";
    private static final String KEY_order_item_qty = "order_details_item_qty";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_Oder_TABLE = "CREATE TABLE " + TABLE_Oder + "("
                + KEY_order_id + " INTEGER PRIMARY KEY,"
                + KEY_order_amount + " TEXT,"
                + KEY_DateTime + " TEXT,"
                + KEY_order_item_name + " TEXT,"
                + KEY_order_item_price + " TEXT,"
                + KEY_order_item_qty + " TEXT" + ")";


        String CREATE_User_TABLE = "CREATE TABLE " + TABLE_User + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_UserPassword + " TEXT,"
                + KEY_UserName + " TEXT,"
                + KEY_Phone + " TEXT,"
                + KEY_DateTime + " TEXT,"
                + KEY_Email + " TEXT" + ")";

        db.execSQL(CREATE_User_TABLE);
        db.execSQL(CREATE_Oder_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_User);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Oder);
        onCreate(db);
    }

    public void add_Oder(String itemName, String itemPrice, String itemQty, String totalPrice) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_order_amount, totalPrice);
        values.put(KEY_order_item_name, itemName);
        values.put(KEY_order_item_price, itemPrice);
        values.put(KEY_order_item_qty, itemQty);
        values.put(KEY_DateTime, currentDateandTime);
        db.insert(TABLE_Oder, null, values);
        db.close();

    }


    @SuppressLint("Range")
    public ArrayList<String> get_All_Orders() {

        ArrayList<String> mAllUserList = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_Oder + " ORDER BY " + KEY_order_id + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String orderId = cursor.getInt(cursor.getColumnIndex(KEY_order_id)) + "";
                String orderAmount = cursor.getString(cursor.getColumnIndex(KEY_order_amount));
                String orderItemName = cursor.getString(cursor.getColumnIndex(KEY_order_item_name));
                String orderItemPrice = cursor.getString(cursor.getColumnIndex(KEY_order_item_price));
                String orderItemQty = cursor.getString(cursor.getColumnIndex(KEY_order_item_qty));

                mAllUserList.add("orderId  : " + orderId + "\n"
                        + "Order Amount  : " + orderAmount + "\n"
                        + "Item Name  : " + orderItemName + "\n"
                        + "Item Price  : " + orderItemPrice + "\n"
                        + "Item Qty  : " + orderItemQty + "\n"
                );
            } while (cursor.moveToNext());
        }
        return mAllUserList;
    }

    public  void create_users(String username,
                             String password,
                             String email,
                             String phone) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_UserName, username);
        values.put(KEY_UserPassword, password);
        values.put(KEY_Email, email);
        values.put(KEY_Phone, phone);
        values.put(KEY_DateTime, currentDateandTime);
        db.insert(TABLE_User, null, values);
        db.close();

    }

    @SuppressLint("Range")
    public ArrayList<String> get_All_Users() {

        ArrayList<String> mAllUserList = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_User + " ORDER BY " + KEY_DateTime + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String userId = cursor.getInt(cursor.getColumnIndex(KEY_ID)) + "";
                String userName = cursor.getString(cursor.getColumnIndex(KEY_UserName));
                String userPhone = cursor.getString(cursor.getColumnIndex(KEY_Phone));
                String userEmail = cursor.getString(cursor.getColumnIndex(KEY_Email));


                mAllUserList.add("userId  : " + userId + "\n"
                        + "User Name  : " + userName + "\n"
                        + "User Phone  : " + userPhone + "\n"
                        + "User Email  : " + userEmail + "\n");

            } while (cursor.moveToNext());
        }
        return mAllUserList;
    }


    public boolean doLogin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "Select * from " + TABLE_User + " where "
                + KEY_UserName + " = " + "'" + username + "' "
                + KEY_UserPassword + " = " + "'" + password + "' ";
        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


}
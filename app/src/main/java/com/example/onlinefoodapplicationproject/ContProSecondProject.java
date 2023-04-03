package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContProSecondProject extends AppCompatActivity {

    Uri CONTENT_URI=Uri.parse("content://com.my.own.detail.provider.onlineFood/emp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_pro_second_project);
    }

    public void showNow(View view) {
        Cursor cr = getContentResolver().query(CONTENT_URI, null, null, null, "id");
        StringBuilder SB = new StringBuilder();
        while (cr.moveToNext()){
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            SB.append(id+" "+s1+" "+s2+" "+ "\n");
        }
        Toast.makeText(this, SB.toString(), Toast.LENGTH_SHORT).show();

    }
}
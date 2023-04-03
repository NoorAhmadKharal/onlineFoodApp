package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class resgInfor extends AppCompatActivity {

    TextView username, userphoneNo, useremail, userpassword, back;
    private View hideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resg_infor);

        hideView = getWindow().getDecorView();
        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0)
                {
                    hideView.setSystemUiVisibility(hideSystemBar());
                }
            }
        });

        username = (TextView) findViewById(R.id.username);
        userphoneNo = (TextView) findViewById(R.id.phoneNo);
        useremail = (TextView) findViewById(R.id.email);
        userpassword = (TextView) findViewById(R.id.password);
        back = (TextView) findViewById(R.id.backuser);

        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        username.setText(sharedPreferences.getString("username", ""));
        userphoneNo.setText(sharedPreferences.getString("userphone", ""));
        useremail.setText(sharedPreferences.getString("useremail", ""));
        userpassword.setText(sharedPreferences.getString("userpassword", ""));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(resgInfor.this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(resgInfor.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {
            hideView.setSystemUiVisibility(hideSystemBar());
        }
    }

    private int hideSystemBar()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}
package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class loginInfor extends AppCompatActivity {

    private View hideView;
    TextView phone, pass, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_infor);

        // Hide bar
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

        // End
        phone = (TextView) findViewById(R.id.phoneNo);
        pass =  (TextView) findViewById(R.id.password);
        back = (TextView) findViewById(R.id.backuser);
        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        phone.setText(sharedPreferences.getString("PhoneNo", ""));
        pass.setText(sharedPreferences.getString("Password", ""));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(loginInfor.this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(loginInfor.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    // Bar Hide
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
package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BeforeHomeActivity extends AppCompatActivity {

    private View hideView;
    TextView login, skip, regis,showResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_home);

        showResults = (TextView) findViewById(R.id.showResults);
        login = (TextView) findViewById(R.id.login);
        skip = (TextView) findViewById(R.id.skip);
        regis = (TextView) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BeforeHomeActivity.this, " Login Click ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BeforeHomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BeforeHomeActivity.this, " Click Skip", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BeforeHomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        showResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BeforeHomeActivity.this, ShowDataBaseResults.class);
                startActivity(intent);
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BeforeHomeActivity.this, "Clicked Register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BeforeHomeActivity.this, regis.class);
                startActivity(intent);
            }
        });

        hideView = getWindow().getDecorView();
        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    hideView.setSystemUiVisibility(hideSystemBar());
                }
            }
        });
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//
//        if (hasFocus) {
//            hideView.setSystemUiVisibility(hideSystemBar());
//        }
//    }

    private int hideSystemBar() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        BeforeHomeActivity.super.onBackPressed();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class splashActivity extends AppCompatActivity {

   // private View hideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//
//        hideView = getWindow().getDecorView();
//        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
//            @Override
//            public void onSystemUiVisibilityChange(int i) {
//                if (i == 0)
//                {
//                    hideView.setSystemUiVisibility(hideSystemBar());
//                }
//            }
//        });

        Thread thread = new Thread()
        {
            public void run() {

                try {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(splashActivity.this, BeforeHomeActivity.class);
                    startActivity(intent);

                }

            }

        };thread.start();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {
            //hideView.setSystemUiVisibility(hideSystemBar());
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
package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class posActivity4 extends AppCompatActivity {

    private View hideView;
    TextView back, pos4;
    EditText EsendPos4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos4);

        pos4 = findViewById(R.id.sendpos4);
        EsendPos4 = findViewById(R.id.rsenter);
        back = findViewById(R.id.back4);

        // payament text code
        pos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(EsendPos4.getText().toString());
                int z = 400 * x;
                Toast.makeText(posActivity4.this, "Click Position 4", Toast.LENGTH_SHORT).show();
                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                databaseHandler.add_Oder("Item1", 400 + "", x + "", z + "");

                Intent intent = new Intent(getApplicationContext(), pay1.class);
                intent.putExtra("message_key", z);
                startActivity(intent);
                finish();
            }
        });
        // back button code
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(posActivity4.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // bar hide
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            hideView.setSystemUiVisibility(hideSystemBar());
        }
    }

    private int hideSystemBar() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}
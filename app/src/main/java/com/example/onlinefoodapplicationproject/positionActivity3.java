package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class positionActivity3 extends AppCompatActivity {

    TextView back, pos3;
    EditText EsendPos3;
    private View hideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position3);

        pos3 = findViewById(R.id.sendpos3);
        EsendPos3 = findViewById(R.id.rsenter);
        hideView = getWindow().getDecorView();
        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    hideView.setSystemUiVisibility(hideSystemBar());
                }
            }
        });

        pos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(EsendPos3.getText().toString());
                //sum these two numbers
                int z = 400 * x;


                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                databaseHandler.add_Oder("Item7", 400 + "", x + "", z + "");


                Toast.makeText(positionActivity3.this, "Click Position 3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), pay3.class);
                intent.putExtra("message_key", z);
                startActivity(intent);
                finish();
            }
        });

        back = findViewById(R.id.back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(positionActivity3.this, MainActivity.class);
                startActivity(intent);
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
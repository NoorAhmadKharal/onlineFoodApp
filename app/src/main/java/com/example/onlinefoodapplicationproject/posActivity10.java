package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class posActivity10 extends AppCompatActivity {

    private View hideView, pos10;
    TextView back;
    EditText EsendPos10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos10);

        pos10 = findViewById(R.id.sendpos10);
        EsendPos10 = findViewById(R.id.rsenter);
        back = findViewById(R.id.back10);

        pos10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(EsendPos10.getText().toString());
                //sum these two numbers
                int z = 1000 * x;
                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                databaseHandler.add_Oder("Item5", 1000 + "", x + "", z + "");

                Toast.makeText(posActivity10.this, "Click Position 10", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), pay1.class);
                intent.putExtra("message_key", z);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(posActivity10.this, MainActivity.class);
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
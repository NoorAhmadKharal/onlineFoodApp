package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class position1Activity extends AppCompatActivity {

    private View hideView;
    TextView back, pos1;
    EditText EsendPos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position1);

        back = (TextView) findViewById(R.id.back1);
        pos1 = (TextView) findViewById(R.id.sendpos1);
        EsendPos1 = (EditText) findViewById(R.id.Editpos1);

        pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int x=Integer.parseInt(EsendPos1.getText().toString());
                //sum these two numbers
                int z = 200*x;


                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                databaseHandler.add_Oder("Item0", 200 + "", x + "", z + "");

                Toast.makeText(position1Activity.this, "Click Position 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), pay1.class);
                intent.putExtra("message_key", z);
                SQLiteDBRegistOnlineFood DB = null;
               
                startActivity(intent);

                finish();


            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(position1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
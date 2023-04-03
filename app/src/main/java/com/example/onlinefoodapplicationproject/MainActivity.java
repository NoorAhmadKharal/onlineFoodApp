package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView horizontal, grid, back;
    private View hideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Back Button Code
        back = (TextView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Back Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, BeforeHomeActivity.class);
                startActivity(intent);
            }
        });

        // Bar Hide Code
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

        // Recycler View Code
        recyclerView = findViewById(R.id.recyclerview);
        horizontal = (TextView) findViewById(R.id.horizontal);
        grid = (TextView) findViewById(R.id.grid);
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("Chicken Skewers", R.drawable.chicken_skewers));
        foods.add(new Food("Fresh Orange Juice Glass", R.drawable.fresh_orange_juice_glass));
        foods.add(new Food("Fried Fish Carp Fresh Vegetable", R.drawable.fried_fish_carp_fresh_vegetable));
        foods.add(new Food("Ril Chicken Legs Flaming Grill", R.drawable.grilled_chicken_legs_flaming_grill_with_grilled_vegetables));
        foods.add(new Food("Grilled Chicken Wings Flaming Grill", R.drawable.grilled_chicken_wings_flaming_grill_with_grilled));
        foods.add(new Food("Grilled Chicken Legs", R.drawable.grilled_chicken_legs));
        foods.add(new Food("Fried Rice With Minced Pork", R.drawable.fried_rice_with_minced_pork));
        foods.add(new Food("Mutton Biryani Food", R.drawable.mutton_biryani_food));
        foods.add(new Food("Plate Fried Fish", R.drawable.plate_fried_fish));
        foods.add(new Food("Fire Berger", R.drawable.burgher));
        FoodAdapter adapter = new FoodAdapter(this,foods);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.setLayoutManager(gridLayoutManager);

            }
        });


        horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            }
        });


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//
//        if (hasFocus)
//        {
//            hideView.setSystemUiVisibility(hideSystemBar());
//        }
//    }

    private int hideSystemBar()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}
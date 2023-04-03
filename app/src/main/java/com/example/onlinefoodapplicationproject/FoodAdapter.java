package com.example.onlinefoodapplicationproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    // Resources access(drawable, image ect), one component to another component pass message(intent)
    // give information about app emviroment
    Context context;
    ArrayList<Food> foods;

    // Constructor
    FoodAdapter(Context context, ArrayList<Food> foods)
    {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_item, parent, false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        final Food temp = foods.get(position);
        Food food = foods.get(position);
        holder.FoodImage.setImageResource(food.getImage());
        holder.tittle.setText(food.getTittle());

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView FoodImage;
        TextView tittle;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            FoodImage = itemView.findViewById(R.id.FoodImage);
            tittle = itemView.findViewById(R.id.tittle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            if (position == 0) {
                Toast.makeText(context, "chicken_skewers ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, position1Activity.class);
                context.startActivity(intent);
            }
            else if (position == 1)
            {

                Toast.makeText(context, "fresh_orange_juice_glass", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, positionActivity2.class);
                context.startActivity(intent);
            }
            else if (position == 2)
            {

                Toast.makeText(context, "fried_fish_carp_fresh_vegetable", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, positionActivity3.class);
                context.startActivity(intent);
            }
            else if (position == 3)
            {

                Toast.makeText(context, "grilled_chicken_legs_flaming_grill_with_grilled_vegetables", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity4.class);
                context.startActivity(intent);
            }
            else if (position == 4)
            {

                Toast.makeText(context, "grilled_chicken_wings_flaming_grill_with_grilled", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity5.class);
                context.startActivity(intent);
            }
            else if (position == 5)
            {

                Toast.makeText(context, "grilled_chicken_legs", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity6.class);
                context.startActivity(intent);
            }
            else if (position == 6)
            {

                Toast.makeText(context, "fried_rice_with_minced_pork", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity7.class);
                context.startActivity(intent);
            }
            else if (position == 7)
            {

                Toast.makeText(context, "mutton_biryani_food", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity8.class);
                context.startActivity(intent);
            }
            else if (position == 8)
            {

                Toast.makeText(context, "mutton_biryani_food", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity9.class);
                context.startActivity(intent);
            }
            else {

                Toast.makeText(context, " fire burgher", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, posActivity10.class);
                context.startActivity(intent);

            }

        }
    }
}

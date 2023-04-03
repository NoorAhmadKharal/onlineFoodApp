package com.example.onlinefoodapplicationproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class ShowDataBaseResults extends Activity {
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] listItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdatabaseresults);
        listView = findViewById(R.id.listView);
        DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());

        String[] listItem = databaseHandler.get_All_Users().toArray(new String[databaseHandler.get_All_Users().size()]);
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.mylist, R.id.textView, listItem);
        listView.setAdapter(adapter);


        findViewById(R.id.users).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] listItem = databaseHandler.get_All_Users().toArray(new String[databaseHandler.get_All_Users().size()]);
                adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.mylist, R.id.textView, listItem);
                listView.setAdapter(adapter);
            }
        });

        findViewById(R.id.orders).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] listItem = databaseHandler.get_All_Orders().toArray(new String[databaseHandler.get_All_Orders().size()]);
                adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.mylist, R.id.textView, listItem);
                listView.setAdapter(adapter);
            }
        });

    }
}

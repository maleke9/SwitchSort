package com.example.user.test.db;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.test.Menue;
import com.example.user.test.R;

import java.util.ArrayList;

/**
 * Created by User on 2/28/2017.
 */

public class Highscore_activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ListDataActivity";

    Button btn_HighToMenu, btn_Reset;
    TextView average;
    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore_list);

        mListView = findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        // Set buttons
        btn_HighToMenu = findViewById(R.id.btn_HighToMenu);
        btn_HighToMenu.setOnClickListener(this);
        btn_Reset = findViewById(R.id.btn_Reset);
        btn_Reset.setOnClickListener(this);

        // Set average
        average = findViewById(R.id.txt_average);
        average.setText(Double.toString(mDatabaseHelper.getavg()));

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        // Get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            // Get the value from the database in column 1
            // then add it to the ArrayList
            listData.add(data.getString(1));
        }
        // Create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        // Set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                if (itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(Highscore_activity.this, EditScore_activity.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", name);
                    startActivity(editScreenIntent);
                } else {
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }

    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_HighToMenu:
                backToMain();
                break;
            case R.id.btn_Reset:
                mDatabaseHelper.deleteAll();
                backToMain();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        backToMain();
    }

    private void backToMain() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

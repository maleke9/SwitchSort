package com.example.user.test;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class About extends Activity implements View.OnClickListener {

    ImageView ivIcon;
    Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Icon image view
        ivIcon = findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.switchsort_icon);

        // Set back button
        btn_Back = findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        backToMain();
    }

    @Override
    public void onClick(View v) {
        backToMain();
    }

    private void backToMain() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

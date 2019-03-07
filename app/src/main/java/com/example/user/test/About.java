package com.example.user.test;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;

public class About extends Activity {

    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Icon image view
        ivIcon = findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.switchsort_icon);
    }

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

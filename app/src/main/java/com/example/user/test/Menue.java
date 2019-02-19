package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menue extends Activity implements View.OnClickListener {

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Fade_pregame.class);
        startActivity(intent);
        this.finish();
    }
}

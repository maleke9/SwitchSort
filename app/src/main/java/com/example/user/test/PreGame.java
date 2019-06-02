package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PreGame extends Activity implements View.OnClickListener {

    Button btnStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_pregame);

        btnStartGame = findViewById(R.id.btn_startGame);
        btnStartGame.setOnClickListener(this);

        Numbers numbers = Numbers.getInstance(this);
        numbers.setGame();

        // Set text view
        TextView tv_toBeSearchedNumber;
        tv_toBeSearchedNumber = findViewById(R.id.tv_toBeSearchedNumber);
        tv_toBeSearchedNumber.setText(numbers.getCorrectAnswer());

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

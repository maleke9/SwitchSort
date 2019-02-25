package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Fade_pregame extends Activity implements View.OnClickListener {

    int[] intArray;
    Button btnStartGame;
    List<Integer> numbers;
    Random randomizer = new Random();
    Random rng = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fade_pregame);
        TextView tv_toBeSearchedNumber;
        tv_toBeSearchedNumber = findViewById(R.id.tv_toBeSearchedNumber);

        btnStartGame = findViewById(R.id.btn_startGame);
        btnStartGame.setOnClickListener(this);

        numbers = numbers(GlobVar.getInstance().gameMode);
        int correctAnswer = numbers.get(randomizer.nextInt(numbers.size()));
        numbers.add(correctAnswer);

        //List to array
        intArray = ArrayUtils.toPrimitive(numbers.toArray(new Integer[numbers.size()]));

        //Store numbers in Global variable
        GlobVar.getInstance().numbers = intArray;
        tv_toBeSearchedNumber.setText(String.format(Locale.GERMAN,"%d", correctAnswer));

    }

    public List<Integer> numbers(int numbersNeeded) {

        List<Integer> generated = new LinkedList<>();
        while (generated.size() < numbersNeeded) {
            Integer next = rng.nextInt(numbersNeeded) + 1;
            generated.add(next);
        }
        return generated;
    }

    @Override
    public void onClick(View v) {
        //Konsolenausgabe via logcat
        //Log.d("Array", numbers.toString());
        Intent intent = new Intent(this, test_dynamic.class);
        startActivity(intent);
        this.finish();
    }
}

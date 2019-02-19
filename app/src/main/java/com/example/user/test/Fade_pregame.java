package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class Fade_pregame extends Activity implements View.OnClickListener {

    private int correctAnswer=-1;
    int[] intArray;
    Button btnStartGame;
    List<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fade_pregame);
        TextView tv_toBeSearchedNumber;
        tv_toBeSearchedNumber= (TextView) findViewById(R.id.tv_toBeSearchedNumber);

        btnStartGame = findViewById(R.id.btn_startGame);
        btnStartGame.setOnClickListener(this);

        numbers = numbers(4);
        Random randomizer = new Random();
        this.correctAnswer = numbers.get(randomizer.nextInt(numbers.size()));
        numbers.add(correctAnswer);
        int[] intArray = ArrayUtils.toPrimitive(numbers.toArray(new Integer[numbers.size()]));
        GlobVar.getInstance().numbers = intArray;
        tv_toBeSearchedNumber.setText( Integer.toString(correctAnswer));


    }

    //Declare timer
    CountDownTimer cTimer = null;
    //Intent intent = new Intent(this, Game.class);

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                millisUntilFinished= millisUntilFinished/1000;
               // tv_CountDown.setText((char)millisUntilFinished);
            }
            public void onFinish() {
                //startActivity(intent.putExtra("array",intArray));;
            }
        };
        cTimer.start();
    }


    //cancel timer
    void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }

    public List<Integer> numbers(int numbersNeeded){
        int max = 10;
        if (max < numbersNeeded)
        {
            throw new IllegalArgumentException("Can't ask for more numbers than are available");
        }
        Random rng = new Random(); // Ideally just create one instance globally
// Note: use LinkedHashSet to maintain insertion order
        List<Integer> generated = new LinkedList<Integer>();
        while (generated.size() < numbersNeeded)
        {
            //Duplikate möglich !
            Integer next = rng.nextInt(max) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }return generated;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Game.class);
        //Konsolenausgabe via logcat
        Log.d("Array", numbers.toString());
        startActivity(intent);
        this.finish();
    }
}

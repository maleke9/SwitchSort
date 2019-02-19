package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game extends Activity implements View.OnClickListener {

    Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4,btnGameExit;
    TextView inGameSearch;
    int correctAnswer = -1;
    List<Integer> generated = new LinkedList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        generated = arrayToList(GlobVar.getInstance().numbers);
        btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);
        btnAnswer4 = (Button) findViewById(R.id.btnAnswer4);
        btnGameExit = (Button) findViewById(R.id.btnGameExit);

        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);
        btnGameExit.setOnClickListener(this);



        setupBtnForGame();
        setCorrectAnswer();

        inGameSearch = (TextView) findViewById(R.id.tv_inGameSearch);
        inGameSearch.setText("Find Number: "+Integer.toString(correctAnswer));
    }

    private void setCorrectAnswer() {
        correctAnswer = GlobVar.getInstance().numbers[GlobVar.getInstance().numbers.length-1];
    }

    @Override
    public void onClick(View v) {
        Log.d("correctAnswer",Integer.toString(correctAnswer));
        switch (v.getId()){
            case R.id.btnAnswer1:
                checkCorrectAnswer(btnAnswer1.getText());
                break;
            case R.id.btnAnswer2:
                checkCorrectAnswer(btnAnswer2.getText());
                break;
            case R.id.btnAnswer3:
                checkCorrectAnswer(btnAnswer3.getText());
                break;
            case R.id.btnAnswer4:
                checkCorrectAnswer(btnAnswer4.getText());
                break;
            case R.id.btnGameExit:
                Intent gameExit = new Intent(this,Menue.class);
                startActivity(gameExit);
                this.finish();
        }
    }
    private List<Integer> arrayToList(int[] ints ){
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : ints)
        {
            intList.add(i);
        }
        return intList;
    }


    private void checkCorrectAnswer(CharSequence text) {
    if(text.equals(Integer.toString(correctAnswer))){
        Intent backToMain = new Intent(this,Menue.class);
        startActivity(backToMain);
        this.finish();
    }
    else{
        Toast toast = Toast.makeText(getApplicationContext(),
                "Wrong Number",
                Toast.LENGTH_SHORT);

        toast.show();
    }
    }

    public void setupBtnForGame(){

        btnAnswer1.setText(generated.get(0).toString());
        btnAnswer2.setText(generated.get(1).toString());
        btnAnswer3.setText(generated.get(2).toString());
        btnAnswer4.setText(generated.get(3).toString());
    }






}

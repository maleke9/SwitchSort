package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements View.OnClickListener {
    GlobVar globVar = GlobVar.getInstance();
    Numbers numbers = Numbers.getInstance();
    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        GridLayout mainLayout = findViewById(R.id.gridlayout);
        mainLayout.setColumnCount((int) Math.sqrt((double)GlobVar.getInstance().gameMode));
        mainLayout.setRowCount((int) Math.sqrt((double)GlobVar.getInstance().gameMode));
        TextView tv_gameShowCorrectAnswer = findViewById(R.id.tv_gameShowCorrectAnswer);
        String gameShowCorrectAnswer = "Find : "+numbers.getCorrectAnswer();
        tv_gameShowCorrectAnswer.setText(gameShowCorrectAnswer);
        createButtons(mainLayout);
        startTime = System.currentTimeMillis();   // Start time for stop watch in milliseconds
    }

    private void createButtons(GridLayout mainLayout) {
        for (int i = 0; i <= globVar.gameMode-1;i ++ ) {
            int temp_number = numbers.gameNumbers[i];

            globVar.temp_text = numbers.getCorrectNumberType(temp_number);

            Button addButton =new Button(this);
            addButton.setId(temp_number);
            addButton.setText(globVar.temp_text);
            addButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    checkCorrectAnswer(((Button) view).getText().toString());
                }
        });
            mainLayout.addView(addButton);
        }
    }

    private void checkCorrectAnswer(String text) {
        if (text.equals(numbers.getCorrectAnswer())) {
            Intent backToMain = new Intent(this, Menue.class);
            long usedTime = System.currentTimeMillis() - startTime;
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Your time: " + usedTime + "ms",
                    Toast.LENGTH_SHORT);
            toast.show();

            startActivity(backToMain);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Wrong Number",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View v) {

    }
}

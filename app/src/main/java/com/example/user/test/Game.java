package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.test.db.DatabaseHelper;

public class Game extends Activity implements View.OnClickListener {
    GlobVar globVar = GlobVar.getInstance(this);
    Numbers numbers = Numbers.getInstance(this);
    ImageView ivIcon;
    long startTime = 0;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        databaseHelper = new DatabaseHelper(this);

        // Grid layout buttons
        GridLayout mainLayout = findViewById(R.id.gridlayout);

        mainLayout.setColumnCount((int) Math.sqrt((double)globVar.getGameMod()));
        mainLayout.setRowCount((int) Math.sqrt((double)globVar.getGameMod()));

        // Set correct answer
        TextView tv_gameShowCorrectAnswer = findViewById(R.id.tv_gameShowCorrectAnswer);
        String gameShowCorrectAnswer = "Find : "+numbers.getCorrectAnswer();
        tv_gameShowCorrectAnswer.setText(gameShowCorrectAnswer);

        //Icon image view
        ivIcon = findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.switchsort_icon);
        ivIcon.setOnClickListener(this);

        createButtons(mainLayout);
        startTime = System.currentTimeMillis();   // Start time for stop watch in milliseconds
    }

    private void createButtons(GridLayout mainLayout) {
        for (int i = 0; i <= globVar.getGameMod()-1;i ++ ) {
            int temp_number = numbers.gameNumbers[i];

            globVar.temp_text = numbers.getCorrectNumberType(temp_number);

            Button addButton =new Button(this);
            addButton.setBackgroundResource(R.drawable.button_border);
            addButton.setTextColor(getResources().getColor(R.color.text));
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
        if (text.equals(numbers.getCorrectNumberType(numbers.correctAnswer))) {
            Intent backToMain = new Intent(this, Menue.class);
            long usedTime = System.currentTimeMillis() - startTime;
            databaseHelper.addData(Long.toString(usedTime));
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

    public void onClick(View v) {
    }

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

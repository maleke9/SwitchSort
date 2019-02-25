package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class test_dynamic extends Activity implements View.OnClickListener {
    int correctAnswer = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dynamic);
        setCorrectAnswer();
        GridLayout mainLayout = (GridLayout)findViewById(R.id.gridlayout);
        mainLayout.setColumnCount((int) Math.sqrt((double)GlobVar.getInstance().gameMode));
        mainLayout.setRowCount((int) Math.sqrt((double)GlobVar.getInstance().gameMode));
        TextView tv_gameShowCorrectAnswer =  (TextView) findViewById(R.id.tv_gameShowCorrectAnswer);
        tv_gameShowCorrectAnswer.setText("Find : "+Integer.toString(correctAnswer));
        createButtons(mainLayout);


    }

    private void createButtons(GridLayout mainLayout) {
        for (int i = 1; i <= GlobVar.getInstance().gameMode; i ++ ) {
            int temp_number = GlobVar.getInstance().numbers[i];
            GlobVar.getInstance().temp_text = Integer.toString(temp_number);

            Button addButton =new Button(this);
            addButton.setId(temp_number);
            addButton.setText(GlobVar.getInstance().temp_text);
            addButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    checkCorrectAnswer(((Button) view).getText().toString());
                }
        });
            mainLayout.addView(addButton);
        }
    }

    private void checkCorrectAnswer(String text) {
        if (text.equals(Integer.toString(correctAnswer))) {
            Intent backToMain = new Intent(this, Menue.class);
            startActivity(backToMain);
            this.finish();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Wrong Number",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    private void setCorrectAnswer() {
        correctAnswer = GlobVar.getInstance().numbers[GlobVar.getInstance().numbers.length - 1];
    }
    @Override
    public void onClick(View v) {

    }
}

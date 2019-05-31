package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.test.db.Highscore_activity;

public class Menue extends Activity implements View.OnClickListener {

    Button btn_Start, btn_Settings,btn_Highscores;
    ImageView ivIcon, ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);

        //Start Game Button
        btn_Start =  findViewById(R.id.btnStart);
        btn_Start.setOnClickListener(this);

        //Settings Button
        btn_Settings =  findViewById(R.id.btnSettings);
        btn_Settings.setOnClickListener(this);

        //Highscore Button
        btn_Highscores = findViewById(R.id.btnHighscores);
        btn_Highscores.setOnClickListener(this);


        //Icon image view
        ivIcon = findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.switchsort_icon);
        ivIcon.setOnClickListener(this);

        //Logo image view
        ivLogo = findViewById(R.id.ivLogo);
        ivLogo.setImageResource(R.drawable.switchsort_logo);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btnSettings:
                Intent toSettings = new Intent(this, SettingsManager.class);
                startActivity(toSettings);
                break;

            case R.id.btnStart:
                Intent toGame = new Intent(this, PreGame.class);
                startActivity(toGame);
                break;
            case R.id.btnHighscores:
                Intent toHighscores = new Intent(this, Highscore_activity.class);
                startActivity(toHighscores);
                break;

            case R.id.ivIcon:
                Intent toAbout = new Intent(this, About.class);
                startActivity(toAbout);
                break;
        }

        this.finish();
    }
}

package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menue extends Activity implements View.OnClickListener {

    Button btn_Start, btn_Settings;
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

            case R.id.ivIcon:
                Intent toAbout = new Intent(this, About.class);
                startActivity(toAbout);
                break;
        }

        this.finish();
    }
}

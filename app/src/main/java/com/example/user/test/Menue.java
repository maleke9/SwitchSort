package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menue extends Activity implements View.OnClickListener {

    Button btn_Start, btn_Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);

        //Start Game Button
        btn_Start =  findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(this);

        //Settings Button
        btn_Settings =  findViewById(R.id.btn_settings);
        btn_Settings.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_settings:
                Intent toSettings = new Intent(this, SettingsManager.class);
                startActivity(toSettings);
                break;

            case R.id.btn_Start:
                Intent toGame = new Intent(this, PreGame.class);
                startActivity(toGame);
                break;
        }

        this.finish();
    }
}

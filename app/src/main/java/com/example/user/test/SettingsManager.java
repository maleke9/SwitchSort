package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsManager extends Activity implements View.OnClickListener {

    Button easy,medium,hard,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsmanager);
        easy = (Button) findViewById(R.id.btn_easy);
        easy.setOnClickListener(this);
        medium = (Button) findViewById(R.id.btn_medium);
        medium.setOnClickListener(this);
        hard = (Button) findViewById(R.id.btn_hard);
        hard.setOnClickListener(this);
        save = findViewById(R.id.btn_save);
        save.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_easy:
                GlobVar.getInstance().gameMode=4;
                break;

            case R.id.btn_medium:
                GlobVar.getInstance().gameMode=9;
                break;

            case R.id.btn_hard:
                GlobVar.getInstance().gameMode=16;
                break;

            case R.id.btn_save:
                Intent toMenue = new Intent(this, Menue.class);
                startActivity(toMenue);
                this.finish();
                break;
        }
        }
}

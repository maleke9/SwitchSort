package com.example.user.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SettingsManager extends Activity implements View.OnClickListener {

    Button btn_Easy, btn_Medium, btn_Hard, btn_Save, btn_Dez, btn_Bin, btn_Hex, btn_Back;
    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsmanager);

        //Icon image view
        ivIcon = findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.switchsort_icon);

        // Set buttons
        btn_Back = findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(this);

        btn_Easy = findViewById(R.id.btn_easy);
        btn_Easy.setOnClickListener(this);

        btn_Medium = findViewById(R.id.btn_medium);
        btn_Medium.setOnClickListener(this);

        btn_Hard = findViewById(R.id.btn_hard);
        btn_Hard.setOnClickListener(this);

        btn_Save = findViewById(R.id.btn_save);
        btn_Save.setOnClickListener(this);

        btn_Dez = findViewById(R.id.btn_dez);
        btn_Dez.setOnClickListener(this);

        btn_Bin = findViewById(R.id.btn_bin);
        btn_Bin.setOnClickListener(this);

        btn_Hex = findViewById(R.id.btn_hex);
        btn_Hex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_easy:
                GlobVar.getInstance(this).setGameMode(4);
                break;
            case R.id.btn_medium:
                GlobVar.getInstance(this).setGameMode(9);
                break;
            case R.id.btn_hard:
                GlobVar.getInstance(this).setGameMode(16);
                break;
            case R.id.btn_save:
                Intent toMenu = new Intent(this, Menue.class);
                startActivity(toMenu);
                this.finish();
                break;
            case R.id.btn_dez:
                GlobVar.getInstance(this).setNumberType(NumberType.DEZ);
                break;
            case R.id.btn_bin :
                GlobVar.getInstance(this).setNumberType(NumberType.BIN);
                break;
            case R.id.btn_hex :
                GlobVar.getInstance(this).setNumberType(NumberType.HEX);
                break;
            case R.id.btn_Back:
                backToMain();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        backToMain();
    }

    private void backToMain() {
        Intent backToMain = new Intent(this, Menue.class);
        startActivity(backToMain);
    }
}

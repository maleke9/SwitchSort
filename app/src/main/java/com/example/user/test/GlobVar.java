package com.example.user.test;

import android.content.Context;
import android.content.SharedPreferences;

public class GlobVar {
    Context context;
    String temp_text;
    SharedPreferences settings;
    private static GlobVar instance = null;

    public GlobVar(Context context) {
        this.context = context;
        settings = context.getSharedPreferences("gameSettings", 0);
    }

    public static GlobVar getInstance(Context context) {
        if (instance == null) {
            instance = new GlobVar(context);
        }
        return instance;
    }

    public int getGameMod() {
        return settings.getInt("gameMode", 4);
    }

    public NumberType getNumberType() {
        switch (settings.getInt("numberType", 10)) {
            case 10:
                return NumberType.DEZ;
            case 2:
                return NumberType.BIN;
            case 16:
                return NumberType.HEX;
            default:
                return NumberType.DEZ;
        }
    }

    public void setNumberType(NumberType numberType) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numberType", numberType.getValue());
        editor.apply();
    }

    public void setGameMode(int gameMode) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("gameMode", gameMode);
        editor.apply();
    }
}

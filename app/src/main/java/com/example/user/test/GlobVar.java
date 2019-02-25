package com.example.user.test;


public class GlobVar {
    int[] numbers;
    int gameMode= 4;
    String temp_text;
    private static GlobVar instance = null;

    private GlobVar() {
    }

    public static GlobVar getInstance() {
        if (instance == null) {
            instance = new GlobVar();
        }
        return instance;
    }
}
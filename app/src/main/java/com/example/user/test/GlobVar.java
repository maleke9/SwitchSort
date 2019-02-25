package com.example.user.test;


public class GlobVar {
    public int[] numbers;
    public int gameMode= 9;
    public String temp_text;
    public int temp;
    private static GlobVar instance = null;

    protected GlobVar() {
    }

    public static GlobVar getInstance() {
        if (instance == null) {
            instance = new GlobVar();
        }
        return instance;
    }
}
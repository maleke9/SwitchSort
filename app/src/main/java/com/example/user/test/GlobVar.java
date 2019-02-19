package com.example.user.test;


public class GlobVar {
    public int[] numbers;
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
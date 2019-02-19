package com.example.user.test;


public class GlobVar {
    public int[] numbers;
    private static GlobVar instance = null;
    protected GlobVar() {
        // Exists only to defeat instantiation.
    }
    public static GlobVar getInstance() {
        if(instance == null) {
            instance = new GlobVar();
        }
        return instance;
    }
}
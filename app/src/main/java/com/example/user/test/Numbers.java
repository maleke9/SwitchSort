package com.example.user.test;

import android.util.Log;
import android.widget.Switch;

import org.apache.commons.lang3.ArrayUtils;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Numbers {
    Random rng = new Random();
    Random randomizer = new Random();
    GlobVar globvar = GlobVar.getInstance();
    int[] gameNumbers;
    int correctAnswer;
    private static Numbers instance = null;

    public static Numbers getInstance() {
        if (instance == null) {
            instance = new Numbers();
        }
        return instance;
    }
        public void getNumbers(int numbersNeeded) {

        List<Integer> generated = new LinkedList<>();
        while (generated.size() < numbersNeeded) {
            Integer next = rng.nextInt(100) + 1;
            generated.add(next);
        }
        this.gameNumbers = intListToIntArray(generated);
    }
    public void setCorrectAnswer(){
        this.correctAnswer = gameNumbers[randomizer.nextInt(globvar.gameMode)];
    }

    public int[] intListToIntArray(List<Integer> intList){
         return ArrayUtils.toPrimitive(intList.toArray(new Integer[intList.size()]));
    }

    public void setGame() {
        getNumbers(globvar.gameMode);
        setCorrectAnswer();
    }
    public String setNumberBin(int number){
    return Integer.toBinaryString(number);
    }
    public String setNumberHex(int number){
    return Integer.toHexString(number);
    }
    public String getCorrectNumberType(int number){
        switch (globvar.numberType){
            case DEZ:
                return Integer.toString(number);
            case BIN:
                return setNumberBin(number);
            case HEX:
                return setNumberHex(number);
                default:
                    throw new RuntimeException();
        }
    }

    public String getCorrectAnswer() {
        return Integer.toString(correctAnswer);
    }
}
package com.example.user.test;

public enum NumberType {
    DEZ(10),BIN(2),HEX(16);

    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

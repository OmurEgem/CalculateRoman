package com.company.model;

public class Number {
    private int value;
    private TypeNumber type;

    public Number(int value, TypeNumber type) {
        this.value = value;
        this.type = type;
    }
    public int getValue() {
        return value;
    }
    public TypeNumber getType() {
        return type;
    }
}

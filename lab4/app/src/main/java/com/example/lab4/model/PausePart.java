package com.example.lab4.model;

public class PausePart extends WorkOutPartBase {
    public PausePart(String type, int length) {
        super(type, length);
    }

    public PausePart(int length) {
        super("Pause", length);
    }
}

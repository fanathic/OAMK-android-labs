package com.example.lab4.model;

public class WorkoutPart extends WorkOutPartBase {

    public WorkoutPart(int length) {
        super("Workout", length);
    }

    public WorkoutPart(String type, int length) {
        super(type, length);
    }
}

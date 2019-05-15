package com.example.lab4.model;

import java.io.Serializable;

public class WorkOutPartBase implements Serializable {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private String type;
    private int length;

    public WorkOutPartBase(String type, int length) {
        this.type = type;
        this.length = length;
    }


}

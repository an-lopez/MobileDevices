package com.escom.ipn.mx.sharedpreferences;

public class Entry {
    int id;
    String name;

    public Entry(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entry() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

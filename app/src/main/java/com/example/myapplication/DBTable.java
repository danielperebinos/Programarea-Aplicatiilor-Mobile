package com.example.myapplication;

import java.util.ArrayList;

public class DBTable {

    public ArrayList<String> names, types;
    String name;

    public DBTable(String name, ArrayList<String> names, ArrayList<String> types){
        this.name = name;
        this.names = names;
        this.types = types;
    }
}

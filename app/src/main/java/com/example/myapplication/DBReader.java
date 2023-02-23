package com.example.myapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DBReader {

    ArrayList<String> types, names;

    public void readSDFile(String FileName, ArrayList<String> types, ArrayList<String> names) {
        String row = "";

        try {
            File myFile = new File("/mnt/sdcard/Download/" + FileName);
            FileInputStream fIn = new FileInputStream(myFile);

            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
            while ((row = myReader.readLine()) != null) {
                this.parse(row, types, names);
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println("Error bitch!!!");
            return;
        }
    }

    public void parse(String line, ArrayList<String> types, ArrayList<String> names) {
        types.add(line.split("\t")[1]);
        names.add(line.split("\t")[0]);
    }

    public DBTable read(String FileName) {
        readSDFile(FileName, types, names);
        return new DBTable(FileName, names, types);
    }
}

package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class DBHelper extends SQLiteOpenHelper {

    public DBTable table = new DBTable("Customers", new ArrayList<>(Arrays.asList("name", "age")), new ArrayList<>(Arrays.asList("text", "int")));

    public DBHelper(Context context) {
        super(context, "myDBase", null, 1);
    }

    public String make_query() {
        String query = "create table " + this.table.name + " (id integer primary key autoincrement,";

        for (int i = 0; i < this.table.types.size(); i++) {
            query += this.table.names + " " + this.table.types + ", ";
        }

        query += ");";
        return query;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = this.make_query();
        System.out.println(query);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

package com.example.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//class DBHelper extends SQLiteOpenHelper {
//    public DBHelper(Context context) {
//        // superclass constructor
//        super(context, "myDBase", null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//    // create table with columns
//        db.execSQL("create table mytable (" + "id integer primary key autoincrement,"
//                        + "name text," + "age text" + ");");
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db,
//                          int oldVersion, int newVersion) {
//    }
//}


public class MainActivity extends Activity {
    final String LOG_TAG = "FromDB";
    Button btnAdd, btnRead, btnClear;
    EditText txtinfo, etfromDB;
    DBHelper dbHelper;
    DBReader dbReader= new DBReader();
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtinfo = (EditText) findViewById(R.id.etName);
        etfromDB = (EditText) findViewById(R.id.etfromDB);

        dbHelper = new DBHelper(this);
        dbHelper.table = dbReader.read("db.txtmonh");

        db = dbHelper.getWritableDatabase();
    }

    public void addInfo(View v) {
        Log.d(LOG_TAG, "--- Insert in mytable: ---");
        ContentValues cv = new ContentValues();
        String name = txtinfo.getText().toString();
        String[] ss = name.split(",");
        cv.put("name", ss[0]);
        cv.put("age", ss[1]);
        long rowID = db.insert("mytable", null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
    }

    public void readInfo(View v) {
        Cursor c = db.query("mytable", null,
                null, null, null, null, null);
        String res = "";

        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int ageColIndex = c.getColumnIndex("age");
            do {
                res = c.getInt(idColIndex) + "," + c.getString(nameColIndex) + "," + c.getString(ageColIndex);
            } while (c.moveToNext());
            etfromDB.setText(res);
        } else {
            Log.d("FromDB", "0 rows");
            etfromDB.setText("0 rows");
        }
        c.close();
    }

    public void clearInfo(View v) {
        // delete all rows
        int clearCount = db.delete("mytable", null, null);
        Log.d(LOG_TAG, "deleted rows count = " + clearCount);
    }
}
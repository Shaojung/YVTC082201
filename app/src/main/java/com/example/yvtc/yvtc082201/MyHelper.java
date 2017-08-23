package com.example.yvtc.yvtc082201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yvtc on 2017/8/23.
 */

public class MyHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "mydata.sqlite";
    final static int VERSION = 2;
    public MyHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"phone\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"name\" VARCHAR, \"tel\" VARCHAR, \"email\" VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2)
        {
            db.execSQL("ALTER TABLE \"main\".\"phone\" ADD COLUMN \"email\" VARCHAR");
        }
    }
}

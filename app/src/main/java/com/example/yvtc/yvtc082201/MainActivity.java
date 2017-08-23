package com.example.yvtc.yvtc082201;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    MyHelper helper = new MyHelper(MainActivity.this);
    File dbFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void clickRead(View v)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        // Cursor c = db.rawQuery("Select * from phone", null);
        Cursor c = db.query("phone", new String[] {"id", "name", "tel"}, null, null , null, null, "id desc");

        while (c.moveToNext())
        {
            Log.d("DB", c.getString(1) + "," + c.getString(2));
        }
        c.close();
        db.close();
    }
//    private void copyDatabase(File dbFile) throws IOException {
//        InputStream is = getAssets().open(DB_NAME);
//        OutputStream os = new FileOutputStream(dbFile);
//        byte[] buffer = new byte[1024];
//        while (is.read(buffer) > 0) {
//            os.write(buffer);
//        }
//        os.flush();
//        os.close();
//        is.close();
//    }

    public void clickAdd(View v)
    {
        SQLiteDatabase db = helper.getWritableDatabase();;
        ContentValues cv = new ContentValues();
        cv.put("name", "CCC");
        cv.put("tel", "3344");
        db.insert("phone", null, cv);
        db.close();
    }
    public void clickUpdate(View v)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", "CDCD");
        cv.put("tel", "4343");
        db.update("phone", cv, "id=?", new String[] {"3"});
        db.close();
    }
    public void clickDelete(View v)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("phone", "id=?", new String[] {"2"});
        db.close();
    }
}

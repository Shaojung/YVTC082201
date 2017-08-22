package com.example.yvtc.yvtc082201;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    final String DB_NAME = "mydata.sqlite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File dbFile = new File(getFilesDir() + File.separator + DB_NAME);
        try {
            copyDatabase(dbFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
        Cursor c = db.rawQuery("Select * from phone", null);
        c.moveToFirst();
        Log.d("DB", c.getString(1));
        c.close();
        db.close();


    }
    private void copyDatabase(File dbFile) throws IOException {
        InputStream is = getAssets().open(DB_NAME);
        OutputStream os = new FileOutputStream(dbFile);

        byte[] buffer = new byte[1024];
        while (is.read(buffer) > 0) {
            os.write(buffer);
        }

        os.flush();
        os.close();
        is.close();
    }
}

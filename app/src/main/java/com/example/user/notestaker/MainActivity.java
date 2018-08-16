package com.example.user.notestaker;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler dbHandler = new DatabaseHandler(this,DatabaseHandler.DATABASE_NAME,null,DatabaseHandler.DATABASE_VERSION);
        mDatabase= dbHandler.getWritableDatabase();

        Button addNote =findViewById(R.id.addNote);


    }
    void moveto(View v)
    {
        Intent in = new Intent(MainActivity.this,EditNoteActivity.class);
        startActivity(in);
    }
}

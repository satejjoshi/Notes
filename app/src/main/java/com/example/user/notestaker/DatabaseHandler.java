package com.example.user.notestaker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.user.notestaker.DatabaseValues.*;
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="NotesStore.db";
    public static final int DATABASE_VERSION= 1;
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE "+ DatabaseValuesSubClass.TABLE_NAME +
                " ( " + DatabaseValuesSubClass._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseValuesSubClass.COLUMN_HEAD+ " TEXT NOT NULL, " +
                DatabaseValuesSubClass.COLUMN_TEXT+ "TEXT NOT NULL" +
                ")";
        db.execSQL(SQL_CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ DatabaseValuesSubClass.TABLE_NAME);
        onCreate(db);

    }
}

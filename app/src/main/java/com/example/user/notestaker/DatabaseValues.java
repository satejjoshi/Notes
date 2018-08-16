package com.example.user.notestaker;

import android.provider.BaseColumns;

public class DatabaseValues {

    private DatabaseValues(){}

    public static final class DatabaseValuesSubClass implements BaseColumns{

        public static final String TABLE_NAME="notesList";
        public static final String COLUMN_HEAD= "heading";
        public static final String COLUMN_TEXT= "notetext";

    }

}

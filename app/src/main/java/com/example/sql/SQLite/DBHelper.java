package com.example.sql.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Computer";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCategory = "CREATE TABLE Category(id text primary key, name text not null)";
        sqLiteDatabase.execSQL(sqlCategory);

        String sqlInsertCategory = "INSERT INTO Category " +
                "VALUES('1', 'Máy tính văn phòng'), " +
                "('2', 'Máy tính gamming')";
        sqLiteDatabase.execSQL(sqlInsertCategory);

        String sqlComputer = "CREATE TABLE computer(id text primary key, name text not null, " +
                "price double not null)";
        sqLiteDatabase.execSQL(sqlComputer);

        String sqlInsertComputer = "INSERT INTO Computer " +
                "VALUES('1', 'Lap1', 50000), " +
                "('2', 'Lap2', 20000)";
        sqLiteDatabase.execSQL(sqlInsertComputer);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlComputer = "DROP TABLE IF EXISTS computer";
        sqLiteDatabase.execSQL(sqlComputer);

        String sqlCategory = "DROP TABLE IF EXISTS Category";
        sqLiteDatabase.execSQL(sqlCategory);

        onCreate(sqLiteDatabase);
    }
}

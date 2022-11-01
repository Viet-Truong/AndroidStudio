package com.example.sql.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.sql.Model.Computer;


public class ComputerDao {
    private SQLiteDatabase db;
    public ComputerDao(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public List<Computer> get(String sql, String ...doiSo) {
        List<Computer> computerList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, doiSo);

        while (cursor.moveToNext()) {
            Computer computer = new Computer();
            computer.setId(cursor.getString(cursor.getColumnIndex("id")));
            computer.setName(cursor.getString(cursor.getColumnIndex("name")));
            computer.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            computerList.add(computer);
        }
        return computerList;
    }

    public List<Computer> getAll() {
        String sql =    "SELECT * " +
                "FROM computer ";
        return get(sql);
    }

    public Computer getById(String id) {
        String sql =    "SELECT * " +
                "FROM computer " +
                "WHERE id = ?";
        List<Computer> computerList = get(sql, id);

        return computerList.get(0);
    }

    public long insert(Computer computer) {
        ContentValues values = new ContentValues();
        values.put("id", computer.getId());
        values.put("name", computer.getName());
        values.put("price", computer.getPrice());

        return db.insert("computer", null, values);
    }

    public long update(Computer computer) {
        ContentValues values = new ContentValues();
        values.put("name", computer.getName());

        return db.update("computer", values, "id = ?", new String[]{String.valueOf(computer.getId())});
    }

    public long delete(String id) {
        return db.delete("computer", "id = ?", new String[]{id});
    }

}

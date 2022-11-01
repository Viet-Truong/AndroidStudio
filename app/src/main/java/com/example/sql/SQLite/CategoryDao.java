package com.example.sql.SQLite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.sql.Model.Category;

public class CategoryDao {
    private SQLiteDatabase db;

    public CategoryDao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Category> get(String sql, String ...doiSo) {
        List<Category> categoryList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, doiSo);

        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getString(cursor.getColumnIndex("id")));
            category.setName(cursor.getString(cursor.getColumnIndex("name")));

            categoryList.add(category);
        }

        return categoryList;
    }

    public List<Category> getAll() {
        String sql =    "SELECT * " +
                "FROM Category";

        return get(sql);
    }
}

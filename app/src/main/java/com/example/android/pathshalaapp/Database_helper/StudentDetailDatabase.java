package com.example.android.pathshalaapp.Database_helper;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class StudentDetailDatabase extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase studentDetail = getApplicationContext().openOrCreateDatabase("Student Detail", MODE_PRIVATE, null);

        studentDetail.execSQL("CREATE TABLE IF NOT EXISTS STUDENT_DETAIL(name VARCHAR,school VARCHAR,mobile INT(10),std INT(2),batch VARCHAR)");

    }
}

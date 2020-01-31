package com.example.LoginPackage.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "Account";
    public static final Integer DATABASE_VERSION = 2;
    public static final String ID_COL = "ID";
    public static final String Username_COL = "Username";
    public static final String Password_COL = "Password";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Username_COL + " TEXT NOT NULL, " +
            Password_COL + " TEXT NOT NULL )";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public AccountDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public long addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Username_COL, user);
        contentValues.put(Password_COL, password);
        long result = db.insert(TABLE_NAME, null, contentValues);

        db.close();
        return result;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {ID_COL};
        String selection = Username_COL + "=?" + " AND " + Password_COL + "=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }
}

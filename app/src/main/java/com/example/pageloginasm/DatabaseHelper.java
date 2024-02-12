package com.example.pageloginasm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myapp.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables
        db.execSQL("CREATE TABLE Users (Id  INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Prenom TEXT, email TEXT, password TEXT, Phone TEXT)");
        db.execSQL("CREATE TABLE Agent (Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Telephone TEXT, CodeAgent TEXT, Motdepass TEXT, zone TEXT)");
        db.execSQL("CREATE TABLE Notification (Id INTEGER PRIMARY KEY AUTOINCREMENT, NameNotif TEXT, DescriptionNotif TEXT, DateNotif TEXT)");
        db.execSQL("CREATE TABLE Evenement (Id INTEGER PRIMARY KEY AUTOINCREMENT, NomEvenement TEXT, DescriptionEvenement TEXT, DateEvenement TEXT , StatutEvenement TEXT , NomClient TEXT)");

   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop tables if they exist
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Agent");
	    db.execSQL("DROP TABLE IF EXISTS Notification");
        db.execSQL("DROP TABLE IF EXISTS Evenement");

        onCreate(db);
    }
}
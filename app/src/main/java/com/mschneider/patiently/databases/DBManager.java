package com.mschneider.patiently.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    // Initialize Variable
    private static final String DATABASE_NAME = "patiently_database";
    private static final String physiciansTable = "physicians";
    private static final String patientsTable = "patients";
    private static final String appointmentsTable = "appointments";

    public DBManager(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      // Create tables
        String physicians_query = "CREATE TABLE "+physiciansTable+" (id INTEGER PRIMARY KEY, name TEXT, email TEXT, phone TEXT, speciality TEXT)";
        String patients_query = "CREATE TABLE "+patientsTable+" (id INTEGER PRIMARY KEY, INTEGER physician_id,  name TEXT , email TEXT, phone TEXT, FOREIGN KEY(physician_id) REFERENCES physicians(id))";
        String appointments_query = "CREATE TABLE "+appointmentsTable+" (id INTEGER PRIMARY KEY, INTEGER patient_id, INTEGER physician_id, title TEXT , date DATETIME, FOREIGN KEY(physician_id) REFERENCES physicians(id), FOREIGN KEY(patient_id) REFERENCES patients(id))";



        db.execSQL(physicians_query);
        db.execSQL(patients_query);
        db.execSQL(appointments_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

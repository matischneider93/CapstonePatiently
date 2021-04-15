package com.mschneider.patiently.databases;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

@Database(entities={Patient.class, Physician.class, Appointment.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase.db";
    private static volatile AppDatabase databaseInstance;
    private static final Object LOCK = new Object();

    public abstract PhysicianDao physicianDao();
    public abstract PatientDao patientDao();
    public abstract AppointmentDao appointmentDao();


    public static AppDatabase getDatabaseInstance(Context context) {

        if (databaseInstance == null) {
            synchronized (LOCK) {
                if (databaseInstance == null) {
                    databaseInstance = (AppDatabase) Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallBack)
                            .build();
                    Toast.makeText(context, "Database being created", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return databaseInstance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private PhysicianDao physicianDao;
        private PatientDao patientDao;
        private AppointmentDao appointmentDao;


        private PopulateDbAsyncTask(AppDatabase db) {

            physicianDao = db.physicianDao();
            patientDao = db.patientDao();
            appointmentDao = db.appointmentDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }





}

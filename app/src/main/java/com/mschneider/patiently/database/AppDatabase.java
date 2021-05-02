package com.mschneider.patiently.database;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mschneider.patiently.database.dao.AppointmentDao;
import com.mschneider.patiently.database.dao.PatientDao;
import com.mschneider.patiently.database.dao.PhysicianDao;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={Patient.class, Physician.class, Appointment.class}, version=2)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase.db";
    private static volatile AppDatabase databaseInstance;
    private static final Object LOCK = new Object();

    public abstract PhysicianDao physicianDao();
    public abstract PatientDao patientDao();
    public abstract AppointmentDao appointmentDao();
    private static final int NO_OF_THREADS = 4;

    static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NO_OF_THREADS);




    public static AppDatabase getDatabaseInstance(Context context) {
        if (databaseInstance == null) {
            synchronized (AppDatabase.class) {
                if (databaseInstance == null) {
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "patiently.db").allowMainThreadQueries().
                            fallbackToDestructiveMigration()
                            .addCallback(roomCallBack)
                            .build();
                }
            }
        }
        return databaseInstance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(databaseInstance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        public PhysicianDao physicianDao;
        public PatientDao patientDao;
        public AppointmentDao appointmentDao;


        public PopulateDbAsyncTask(AppDatabase db) {

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

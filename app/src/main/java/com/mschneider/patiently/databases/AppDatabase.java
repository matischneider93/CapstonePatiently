package com.mschneider.patiently.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

@Database(entities={Patient.class, Physician.class, Appointment.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    // Declare daos as abstract
    public abstract PatientDao patientDao();
    public abstract PhysicianDao physicianDao();
    public abstract AppointmentDao appointmentDao();

    // Database name to be used
    public static final String NAME = "AppDatabase";





}

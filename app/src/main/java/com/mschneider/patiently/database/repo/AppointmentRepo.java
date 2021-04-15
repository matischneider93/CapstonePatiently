package com.mschneider.patiently.database.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.database.dao.AppointmentDao;
import com.mschneider.patiently.models.Appointment;

import java.util.List;

public class AppointmentRepo {
    private AppointmentDao appointmentDao;
    private LiveData<List<Appointment>> allAppointments;


    public AppointmentRepo(Application application){
        AppDatabase appDatabase = (AppDatabase) AppDatabase.getDatabaseInstance(application.getApplicationContext());
        appointmentDao = appDatabase.appointmentDao();
        allAppointments = appointmentDao.getAllAppointments();

    }

    //Insert methods
    public void insertAppointment(Appointment appointment){
        new AppointmentRepo.InsertAppointmentAsyncTask(appointmentDao).execute(appointment);

    }

    //Delete methods
    public void deleteAppointment(Appointment appointment){
        new AppointmentRepo.DeleteAppointmentAsyncTask(appointmentDao).execute(appointment);

    }

    public void deleteAllAppointments(){
        new AppointmentRepo.DeleteAllAppointmentsAsyncTask(appointmentDao).execute();

    }


    //Get methods
    public LiveData<List<Appointment>> getAllAppointments(){
        return allAppointments;
    }

    public Appointment getAppointmentById(int appointmentId){
        return appointmentDao.getAppointmentById(appointmentId);
    }

    private static class InsertAppointmentAsyncTask extends AsyncTask<Appointment, Void, Void> {
        private AppointmentDao appointmentDao;

        private InsertAppointmentAsyncTask(AppointmentDao appointmentDao){
            this.appointmentDao = appointmentDao;
        }

        @Override
        protected Void doInBackground(Appointment ... appointments) {
            appointmentDao.insertAppointments((List<Appointment>) appointments[0]);
            return null;
        }
    }

    private static class DeleteAppointmentAsyncTask extends AsyncTask<Appointment, Void, Void>{
        private AppointmentDao appointmentDao;

        private DeleteAppointmentAsyncTask(AppointmentDao appointmentDao){
            this.appointmentDao = appointmentDao;
        }

        @Override
        protected Void doInBackground(Appointment... appointments) {
            appointmentDao.deleteAppointment(appointments[0]);
            return null;
        }
    }

    private static class DeleteAllAppointmentsAsyncTask extends AsyncTask<Void, Void, Void>{
        private AppointmentDao appointmentDao;

        private DeleteAllAppointmentsAsyncTask(AppointmentDao appointmentDao){
            this.appointmentDao = appointmentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            appointmentDao.deleteAllAppointments();
            return null;
        }
    }
}

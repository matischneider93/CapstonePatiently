package com.mschneider.patiently.database.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.database.dao.PatientDao;
import com.mschneider.patiently.models.Patient;

import java.util.List;

public class PatientRepo {
    private PatientDao patientDao;
    private List<Patient> allPatients;


    public PatientRepo(Application application){
        AppDatabase appDatabase = (AppDatabase) AppDatabase.getDatabaseInstance(application.getApplicationContext());
        patientDao = appDatabase.patientDao();
        allPatients = patientDao.getAllPatients();

    }

    //Insert methods
    public void insertPatient(Patient patient){
        new PatientRepo.InsertPatientAsyncTask(patientDao).execute(patient);

    }

    //Delete methods
    public void deletePatient(Patient patient){
        new PatientRepo.DeletePatientAsyncTask(patientDao).execute(patient);

    }

    public void deleteAllPatients(){
        new PatientRepo.DeleteAllPatientsAsyncTask(patientDao).execute();

    }


    //Get methods
    public List<Patient> getAllPatients(){
        return allPatients;
    }

    public Patient getPatientById(int patientId){
        return patientDao.getPatientById(patientId);
    }

    private static class InsertPatientAsyncTask extends AsyncTask<Patient, Void, Void> {
        private PatientDao patientDao;

        private InsertPatientAsyncTask(PatientDao patientDao){
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient ... patients) {
            patientDao.insertPatients((List<Patient>) patients[0]);
            return null;
        }
    }

    private static class DeletePatientAsyncTask extends AsyncTask<Patient, Void, Void>{
        private PatientDao patientDao;

        private DeletePatientAsyncTask(PatientDao patientDao){
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {
            patientDao.deletePatient(patients[0]);
            return null;
        }
    }

    private static class DeleteAllPatientsAsyncTask extends AsyncTask<Void, Void, Void>{
        private PatientDao patientDao;

        private DeleteAllPatientsAsyncTask(PatientDao patientDao){
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            patientDao.deleteAllPatients();
            return null;
        }
    }
}

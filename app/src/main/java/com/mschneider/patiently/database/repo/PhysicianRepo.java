package com.mschneider.patiently.database.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.database.dao.PhysicianDao;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class PhysicianRepo {
    private PhysicianDao physicianDao;
    private LiveData<List<Physician>> allPhysicians;


    public PhysicianRepo(Application application){
        AppDatabase appDatabase = (AppDatabase) AppDatabase.getDatabaseInstance(application.getApplicationContext());
        physicianDao = appDatabase.physicianDao();
        allPhysicians = physicianDao.getAllPhysicians();

    }

    //Insert methods
    public void insertPhysician(Physician physician){
        new InsertPhysicianAsyncTask(physicianDao).execute(physician);

    }

    //Delete methods
    public void deletePhysician(Physician physician){
        new DeletePhysicianAsyncTask(physicianDao).execute(physician);

    }

    public void deleteAllPhysicians(){
        new DeleteAllPhysiciansAsyncTask(physicianDao).execute();

    }


    //Get methods
    public LiveData<List<Physician>> getAllPhysicians(){
        return allPhysicians;
    }

    public Physician getPhysicianById(int physicianId){
        return physicianDao.getPhysicianById(physicianId);
    }

    private static class InsertPhysicianAsyncTask extends AsyncTask<Physician, Void, Void> {
        private PhysicianDao physicianDao;

        private InsertPhysicianAsyncTask(PhysicianDao physicianDao){
            this.physicianDao = physicianDao;
        }

        @Override
        protected Void doInBackground(Physician ... physicians) {
            physicianDao.insertPhysicians((List<Physician>) physicians[0]);
            return null;
        }
    }

    private static class DeletePhysicianAsyncTask extends AsyncTask<Physician, Void, Void>{
        private PhysicianDao physicianDao;

        private DeletePhysicianAsyncTask(PhysicianDao physicianDao){
            this.physicianDao = physicianDao;
        }

        @Override
        protected Void doInBackground(Physician... physicians) {
            physicianDao.deletePhysicians(physicians[0]);
            return null;
        }
    }

    private static class DeleteAllPhysiciansAsyncTask extends AsyncTask<Void, Void, Void>{
        private PhysicianDao physicianDao;

        private DeleteAllPhysiciansAsyncTask(PhysicianDao physicianDao){
            this.physicianDao = physicianDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            physicianDao.deleteAllPhysicians();
            return null;
        }
    }
}

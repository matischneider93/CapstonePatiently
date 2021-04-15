package com.mschneider.patiently.database.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.repo.PatientRepo;
import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {

    private PatientRepo mRepository;

    private LiveData<List<Patient>> mAllPatients;

    public PatientViewModel (Application application) {
        super(application);
        mRepository = new PatientRepo(application);
        mAllPatients = mRepository.getAllPatients();
    }

    LiveData<List<Patient>> getAllPatients() { return mAllPatients; }

    public void insert(Patient patient) { mRepository.insertPatient(patient); }
}
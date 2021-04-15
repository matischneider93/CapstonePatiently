package com.mschneider.patiently.database.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class PhysicianViewModel extends AndroidViewModel {

    private PhysicianRepo mRepository;

    private LiveData<List<Physician>> mAllPhysicians;

    public PhysicianViewModel (Application application) {
        super(application);
        mRepository = new PhysicianRepo(application);
        mAllPhysicians = mRepository.getAllPhysicians();
    }

    LiveData<List<Physician>> getAllPhysicians() { return mAllPhysicians; }

    public void insert(Physician physician) { mRepository.insertPhysician(physician); }
}
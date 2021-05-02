package com.mschneider.patiently.database.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.models.Physician;

import java.util.ArrayList;
import java.util.List;

public class PhysicianViewModel extends AndroidViewModel {
    private PhysicianRepo mRepository;
    public List<Physician> mAllPhysicians;




    public PhysicianViewModel (@NonNull Application application) {
        super(application);
        mRepository = new PhysicianRepo(application);
        mAllPhysicians = mRepository.getAllPhysicians();
    }


    public List<Physician> getAllPhysicians() { return mAllPhysicians; }

    public void insert(Physician physician) { mRepository.insertPhysician(physician); }


}
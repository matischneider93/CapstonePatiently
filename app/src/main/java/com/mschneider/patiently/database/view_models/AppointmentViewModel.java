package com.mschneider.patiently.database.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mschneider.patiently.database.repo.AppointmentRepo;
import com.mschneider.patiently.database.repo.PatientRepo;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Patient;

import java.util.List;

public class AppointmentViewModel extends AndroidViewModel {

    private AppointmentRepo mRepository;

    private LiveData<List<Appointment>> mAllAppointments;

    public AppointmentViewModel (Application application) {
        super(application);
        mRepository = new AppointmentRepo(application);
        mAllAppointments = mRepository.getAllAppointments();
    }

    LiveData<List<Appointment>> getAllAppointments() { return mAllAppointments; }

    public void insert(Appointment appointment) { mRepository.insertAppointment(appointment); }
}
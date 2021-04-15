package com.mschneider.patiently.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mschneider.patiently.models.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPatient(Patient Patient);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPatients(List<Patient> patients);

    @Delete
    void deletePatient(Patient Patient);

    @Query("SELECT * FROM patients WHERE patientId = :patientId")
    Patient getPatientById(int patientId);

    @Query("SELECT * FROM patients ORDER BY patientId ASC")
    LiveData<List<Patient>> getAllPatients();

    @Query("DELETE FROM patients")
    int deleteAllPatients();

    @Query("SELECT COUNT(*) FROM patients")
    int getPatientCount();

}

package com.mschneider.patiently.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mschneider.patiently.models.Physician;

import java.util.List;

@Dao
public interface PhysicianDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhysician(Physician physician);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhysicians(List<Physician> physicians);

    @Delete
    void deletePhysicians(Physician physician);

    @Query("SELECT * FROM physicians WHERE physicianId = :physicianId")
    Physician getPhysicianById(int physicianId);

    @Query("SELECT * FROM physicians ORDER BY physicianId ASC")
    LiveData<List<Physician>> getAllPhysicians();

    @Query("DELETE FROM physicians")
    int deleteAllPhysicians();

    @Query("SELECT COUNT(*) FROM physicians")
    int getPhysicianCount();
}

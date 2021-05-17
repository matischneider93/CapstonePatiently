package com.mschneider.patiently.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mschneider.patiently.models.Appointment;

import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAppointment(Appointment appointment);

    @Update
    void updateAppointment(Appointment appointment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAppointments(List<Appointment> appointments);

    @Delete
    void deleteAppointment(Appointment appointment);

    @Query("SELECT * FROM appointments WHERE  appointmentId =:appointmentId")
    Appointment getAppointmentById(int appointmentId);

    @Query("SELECT * FROM appointments ORDER BY appointmentId ASC")
    List<Appointment> getAllAppointments();

    @Query("DELETE FROM appointments")
    int deleteAllAppointments();

    @Query("SELECT COUNT(*) FROM appointments")
    int getAppointmentCount();

    @Query("DELETE FROM appointments WHERE  appointmentId =:selectedPosition")
    void deleteAppointment(int selectedPosition);


}

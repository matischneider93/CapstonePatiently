package com.mschneider.patiently.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
   
@Entity(tableName = "appointments")
public class Appointment {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int appointmentId;
    @ColumnInfo(name = "physician_Id")
    private int physicianId;
    @ColumnInfo(name = "patient_Id")
    private int patientId;
    @ColumnInfo(name = "appointment_title")
    private String appointmentTitle;
    @ColumnInfo(name = "appointment_type")
    private String appointmentType;
    @ColumnInfo(name = "appointment_date")
    private String appointmentDate;
    @ColumnInfo(name = "appointment_time")
    private String appointmentTime;



    @Ignore
    public Appointment(int appointmentId, int physicianId, int patientId, String appointmentTitle, String appointmentType, String appointmentDate, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.physicianId = physicianId;
        this.patientId = patientId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
    @Ignore
    public Appointment(int physicianId, int patientId, String appointmentTitle, String appointmentType, String appointmentDate, String appointmentTime) {
        this.physicianId = physicianId;
        this.patientId = patientId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
    @Ignore
    public Appointment(int patientId, String appointmentTitle, String appointmentType, String appointmentDate, String appointmentTime) {
        this.patientId = patientId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Appointment(String appointmentTitle, String appointmentType, String appointmentDate, String appointmentTime) {
        this.appointmentTitle = appointmentTitle;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Appointment() {
        this.appointmentId = 1;
        this.physicianId = 1;
        this.patientId = 1;
        this.appointmentTitle = "N/A";
        this.appointmentType = "N/A";
        this.appointmentDate = "N/A";
        this.appointmentTime = "N/A";
    }

    public int getAppointmentId() {
        return appointmentId;
    }
    public int getPhysicianId() {
        return physicianId;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getAppointmentTitle() {
        return appointmentTitle;
    }
    public String getAppointmentType() {
        return appointmentType;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }


}

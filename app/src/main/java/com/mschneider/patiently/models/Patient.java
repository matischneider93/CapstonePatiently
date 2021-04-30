package com.mschneider.patiently.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients", foreignKeys = {@ForeignKey(entity = Physician.class,
        parentColumns = "physicianId",
        childColumns = "physicianId")
})
public class Patient {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    public int patientId;
    public int physicianId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "blood_type")
    public String bloodType;
    @ColumnInfo(name = "vaccinated")
    public Boolean vaccinated;
    @ColumnInfo(name = "insurance_provider")
    public String insuranceProvider;

    public Patient(int physicianId, String firstName, String lastName, String email, String phone, String bloodType, Boolean vaccinated, String insuranceProvider) {
        this.physicianId = physicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.bloodType = bloodType;
        this.vaccinated = vaccinated;
        this.insuranceProvider = insuranceProvider;
    }
    public Patient(int patientId, int physicianId, String firstName, String lastName, String email, String phone, String bloodType, Boolean vaccinated, String insuranceProvider) {
        this.patientId = patientId;
        this.physicianId = physicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.bloodType = bloodType;
        this.vaccinated = vaccinated;
        this.insuranceProvider = insuranceProvider;
    }
    public Patient(){
        physicianId = 1;
        firstName = " N/A";
        lastName = " N/A";
        email = "N/A";
        phone = "N/A";
        bloodType = "N/A";
        vaccinated = false;
        insuranceProvider = "N/A";
    }
    public int getPatientId() {
        return patientId;
    }
    public int getPhysicianId() {
        return physicianId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getBloodType() {
        return bloodType;
    }
    public Boolean getVaccinated() {
        return vaccinated;
    }
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }
}



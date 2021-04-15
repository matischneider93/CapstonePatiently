package com.mschneider.patiently.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "physicians")
public class Physician {
    @PrimaryKey
    public int physicianId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "speciality")
    public String speciality;

    public Physician(int physicianId, String firstName, String lastName, String email, String phone, String speciality) {
        this.physicianId = physicianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
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
    public String getSpeciality() {
        return speciality;
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
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}

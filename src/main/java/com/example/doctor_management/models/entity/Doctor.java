package com.example.doctor_management.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_code", length = 50, unique = true, nullable = false)
    private String doctorCode;

    @Column(name= "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(length = 255, nullable = false)
    private String specialization;

    @Column(name = "experience_years", nullable = false)
    private int experienceYears;

    public Doctor() {
    }

    public Doctor(String doctorCode, String fullName, String specialization, int experienceYears) {
        this.doctorCode = doctorCode;
        this.fullName = fullName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public Long getId() {
        return id;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}

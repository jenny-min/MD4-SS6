package com.example.doctor_management.models.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_code", length = 50, nullable = false)
    private String patientCode;

    @Column(name= "full_name", length = 250, nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @OneToMany(mappedBy = "patient")
    private Set<MedicalRecord> medicalRecords = new HashSet<>();

    public Patient() {
    }

    public Patient(String patientCode, String fullName, String phone, String address) {
        this.patientCode = patientCode;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.example.doctor_management.models.entity;

import com.example.doctor_management.models.MedicalRecordStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300, nullable = false)
    private String diagnosis;

    @Enumerated(EnumType.STRING)
    private MedicalRecordStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalRecord() {
    }

    public MedicalRecord(Long id, String diagnosis, MedicalRecordStatus status, LocalDateTime createdAt, Doctor doctor, Patient patient) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.status = status;
        this.createdAt = createdAt;
        this.doctor = doctor;
        this.patient = patient;
    }

    @PrePersist //Tự động chạy trước khi insert DB
    public void prePersist() {
        // Automatically set the creation timestamp
        this.createdAt = LocalDateTime.now();
        this.status = MedicalRecordStatus.PROCESSING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public MedicalRecordStatus getStatus() {
        return status;
    }

    public void setStatus(MedicalRecordStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

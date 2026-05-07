package com.example.doctor_management.models.dto;

public class MedicalRecordRequest {
    private Long doctorId;
    private Long patientId;
    private String diagnosis;

    public MedicalRecordRequest() {
    }

    public MedicalRecordRequest(Long doctorId, Long patientId, String diagnosis) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

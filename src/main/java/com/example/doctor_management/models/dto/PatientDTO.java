package com.example.doctor_management.models.dto;

public class PatientDTO {
    private Long id;
    private String name;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}

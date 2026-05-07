package com.example.doctor_management.controllers;

import com.example.doctor_management.models.dto.MedicalRecordRequest;
import com.example.doctor_management.models.entity.MedicalRecord;
import com.example.doctor_management.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/medical-records")
    public ResponseEntity<MedicalRecord>  addMedicalRecord(@RequestBody MedicalRecordRequest request) {
        return ResponseEntity.status(201).body(medicalRecordService.createMedicalRecord(request));
    }
}

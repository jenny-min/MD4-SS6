package com.example.doctor_management.controllers;

import com.example.doctor_management.models.entity.Patient;
import com.example.doctor_management.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    PatientService ps;

    @PostMapping()
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(201).body(ps.createPatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id) {
        return ResponseEntity.ok().build(); //Trả về 204
    }
}

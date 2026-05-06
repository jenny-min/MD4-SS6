package com.example.doctor_management.controllers;

import com.example.doctor_management.models.dto.PaginationResponse;
import com.example.doctor_management.models.dto.PatientDTO;
import com.example.doctor_management.models.entity.Patient;
import com.example.doctor_management.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        ps.deletePatient(id);
        return ResponseEntity.ok().build(); //Trả về 204
    }

    @GetMapping("/search")
    public PaginationResponse<PatientDTO> searchPatients(
            @RequestParam(required = false) String patientName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ps.searchPatients(patientName, page, size);
    }
}

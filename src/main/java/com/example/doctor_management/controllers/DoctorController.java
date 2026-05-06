package com.example.doctor_management.controllers;

import com.example.doctor_management.models.entity.Doctor;
import com.example.doctor_management.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    DoctorService ds;

    @GetMapping()
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(ds.getAllDoctors());
    }

    @PostMapping()
    public ResponseEntity<Doctor> createDoctors(@RequestBody Doctor doctor) {
        return ResponseEntity.status(201).body(ds.createDoctors(doctor));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctors(@PathVariable Long id) {
        ds.deleteDoctors(id);
        return ResponseEntity.ok().build();//Trả về 204 - Xóa thành công
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctors(@RequestBody Doctor doctor, @PathVariable Long id) {
        return ResponseEntity.ok(ds.updateDoctor(id, doctor));
    }
}

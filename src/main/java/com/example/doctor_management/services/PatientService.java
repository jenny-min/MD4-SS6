package com.example.doctor_management.services;

import com.example.doctor_management.models.entity.Patient;
import com.example.doctor_management.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PatientService {
    @Autowired
    private PatientRepository pr;

    public Patient createPatient(@RequestBody Patient patient) {
        return pr.save(patient);
    }

    public void deletePatient(Long id) {
        if (!pr.existsById(id)) {
            throw new RuntimeException("Không tồn tại bệnh nhân có ID " + id);
        }
        pr.deleteById(id);
    }
}

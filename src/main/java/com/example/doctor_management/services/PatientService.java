package com.example.doctor_management.services;

import com.example.doctor_management.models.dto.PaginationResponse;
import com.example.doctor_management.models.dto.PatientDTO;
import com.example.doctor_management.models.entity.Patient;
import com.example.doctor_management.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    public Page<Patient> findAllAndSearch(Pageable pageable , String patientName) {
        if (patientName == null || patientName.trim().isEmpty()) {
            return pr.findAll(pageable);
        }
        return pr.findByFullNameContaining(patientName, pageable);
    }

    public PaginationResponse<PatientDTO> searchPatients(String patientName, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("fullName").ascending());

        Page<Patient> p = findAllAndSearch(pageable, patientName);

        List<PatientDTO> dtoList = p.getContent()
                .stream()
                .map(patient -> new PatientDTO(patient.getId(), patient.getFullName()))
                .toList();

        return new PaginationResponse<>(
                dtoList,
                p.getTotalPages(),
                p.getTotalElements(),
                p.getNumber()
        );
    }
}

package com.example.doctor_management.services;

import com.example.doctor_management.models.entity.Doctor;
import com.example.doctor_management.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor createDoctors(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public void deleteDoctors(Long id) {
        if (!doctorRepo.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bác sĩ có ID " + id);
        }
        doctorRepo.deleteById(id);
    }
}

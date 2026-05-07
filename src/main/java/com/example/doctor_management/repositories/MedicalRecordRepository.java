package com.example.doctor_management.repositories;

import com.example.doctor_management.models.MedicalRecordStatus;
import com.example.doctor_management.models.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    //Trước khi lưu, kiểm tra xem bệnh nhân (patientId)
    // đã có hồ sơ nào mà trạng thái chưa phải là DONE (tức là đang PROCESSING) hay chưa
    boolean existsByPatientIdAndStatus(Long patient_id, MedicalRecordStatus status);
}

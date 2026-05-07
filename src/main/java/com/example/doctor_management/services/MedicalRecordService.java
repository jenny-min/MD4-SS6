package com.example.doctor_management.services;

import com.example.doctor_management.models.MedicalRecordStatus;
import com.example.doctor_management.models.dto.MedicalRecordRequest;
import com.example.doctor_management.models.entity.Doctor;
import com.example.doctor_management.models.entity.MedicalRecord;
import com.example.doctor_management.models.entity.Patient;
import com.example.doctor_management.repositories.DoctorRepository;
import com.example.doctor_management.repositories.MedicalRecordRepository;
import com.example.doctor_management.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository mr;

    @Autowired
    private DoctorRepository dr;

    @Autowired
    private PatientRepository pr;

    public MedicalRecord createMedicalRecord(MedicalRecordRequest request) {
        //Kiểm tra id và trạng thái bệnh nhân qua hàm existsByPatientIdAndStatus đã set ở repo
        boolean exits = mr.existsByPatientIdAndStatus(
                request.getPatientId(),
                MedicalRecordStatus.PROCESSING
        );
        //Nếu tồn tại ID - báo
        if (exits) {
            throw new RuntimeException(
                    "Bệnh nhân này hiện đang có hồ sơ điều trị chưa hoàn thành"
            );
        }

        //nếu k tồn tại ID ->
        //tìm bác sĩ
        Doctor doctor = dr.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ"));

        //tìm bệnh nhân
        Patient patient = pr.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân"));

        //Tạo bệnh án mới
        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setDoctor(doctor);
        medicalRecord.setPatient(patient);
        //Lưu vào bệnh án
        return mr.save(medicalRecord);
    }
}

package com.trootech.Hospitalappbackend.service;

import com.trootech.Hospitalappbackend.entity.Doctor;
import com.trootech.Hospitalappbackend.exception.DoctorAlreadyExistException;
import com.trootech.Hospitalappbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        if (doctorRepository.existsByEmailId(doctor.getEmailId())) {
            throw new DoctorAlreadyExistException("Doctor with email " + doctor.getEmailId() + " already exists");
        }
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(int id, Doctor doctor) {
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}


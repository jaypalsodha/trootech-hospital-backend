package com.trootech.Hospitalappbackend.repository;

import com.trootech.Hospitalappbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    // You can add any custom methods you need here
    // for example, you can add a method to find doctors by name
    List<Doctor> findByName(String name);

    boolean existsByEmailId(String emailId);
}


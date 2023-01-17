package com.trootech.Hospitalappbackend.repository;

import com.trootech.Hospitalappbackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}

package com.trootech.Hospitalappbackend.service;

import com.trootech.Hospitalappbackend.entity.Appointment;
import com.trootech.Hospitalappbackend.exception.DoctorNotFoundException;
import com.trootech.Hospitalappbackend.repository.AppointmentRepository;
import com.trootech.Hospitalappbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment createAppointment(Appointment appointment) {
        if (appointment.getDoctorId() != null) {
            appointment.setDoctor(doctorRepository.findById(appointment.getDoctorId()).get());
            return appointmentRepository.save(appointment);
        }
        throw new DoctorNotFoundException("Doctor is not selected");
    }

    public Appointment updateAppointment(Integer id, Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setPatientEmail(appointment.getPatientEmail());
            existingAppointment.setPatientMobile(appointment.getPatientMobile());
            existingAppointment.setPatientDOB(appointment.getPatientDOB());
            existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
            existingAppointment.setDoctor(appointment.getDoctor());
            return appointmentRepository.save(existingAppointment);
        }
        return null;
    }

    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }
}

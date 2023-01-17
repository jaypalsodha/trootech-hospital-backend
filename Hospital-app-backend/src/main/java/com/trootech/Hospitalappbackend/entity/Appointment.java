package com.trootech.Hospitalappbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String patientName;

    @Email
    @NotBlank
    @Column(name = "emailid")
    private String patientEmail;

    @NotBlank
    @Column(name = "patientMobileNo")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String patientMobile;

    @Column(name = "patientDOB")
    private Date patientDOB;

    @Column(name = "appointmentDate")
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Transient
    private Integer doctorId;
}

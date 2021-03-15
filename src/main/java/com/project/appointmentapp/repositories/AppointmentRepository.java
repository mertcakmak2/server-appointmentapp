package com.project.appointmentapp.repositories;

import com.project.appointmentapp.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository <Appointment, Integer> {


}

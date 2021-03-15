package com.project.appointmentapp.dataaccess.appointment;

import com.project.appointmentapp.dto.customer.AppointmentRequest;
import com.project.appointmentapp.entities.Appointment;

import java.util.List;

public interface IAppointmentDal  {

    List<Appointment> findAll();
    Appointment findById(int appId);
    Appointment save(Appointment appointment);
    int delete(int appId);

}

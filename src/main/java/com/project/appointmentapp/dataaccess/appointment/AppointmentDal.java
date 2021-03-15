package com.project.appointmentapp.dataaccess.appointment;

import com.project.appointmentapp.dto.customer.AppointmentRequest;
import com.project.appointmentapp.entities.Appointment;
import com.project.appointmentapp.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppointmentDal implements IAppointmentDal {

    private final AppointmentRepository repository;

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Override
    public Appointment findById(int appId) {
        return repository.findById(appId).get();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public int delete(int appId) {
        repository.deleteById(appId);
        return appId;
    }
}
